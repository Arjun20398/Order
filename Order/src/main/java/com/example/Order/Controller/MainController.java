package com.example.Order.Controller;


import com.example.Order.CartDTO.CartDTO;
import com.example.Order.CartDTO.RespFromUser;
import com.example.Order.CartDTO.ToCart;
import com.example.Order.CartDTO.ToMerchant;
import com.example.Order.Model.OrderDTO;
import com.example.Order.ResponseFromCart.ResponseFromCart;
import com.example.Order.Services.OrderServiceImpl.OrderServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.scheduling.quartz.SimpleTriggerBean;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.*;


@RestController
public class MainController {
    public static Map<String ,String> mailqueue= new HashMap<>();
    @Autowired
    private OrderServiceImplementation service;



    @PostMapping(value="/addorder",consumes={"application/json"})
    public String addOrder(@RequestBody RespFromUser order)
    {
        ToMerchant tomerchant=new ToMerchant();
        String url="http://172.16.20.24:8080/merchant/updatequantity";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ToCart tocart;
        String url1="http://172.16.20.61:8080/cart/delete/";
        HttpHeaders headers1 = new HttpHeaders();
        headers1.setContentType(MediaType.APPLICATION_JSON);

        OrderDTO orderdto = new OrderDTO();
        CartDTO[] cartlist=order.getProductlist();
        orderdto.setBillingaddress(order.getBillingaddress());
        orderdto.setEmailid(order.getEmailid());
        orderdto.setShipingaddress(order.getBillingaddress());
        orderdto.setPaymentoption(order.getPaymentoption());
        orderdto.setUserid(order.getUserid());
        orderdto.setOrderdate(order.getOrderdate());
        Long orderid = service.getsize();

        double tax=0,total=0;
        String message="Order Invoice from BAZAAR   "+"\n\n\n"+
                "Order Date : "+order.getOrderdate()+"\n"+
                "Email : "+order.getEmailid()+"\n"+
                "Payment Option : "+order.getPaymentoption()+"\n"+
                "Billing Address : "+order.getBillingaddress()+"\n"+
                "Shiping Address : "+order.getShippingaddress()+"\n";

        if(cartlist==null||cartlist.length==0)
        {
            return "failure";
        }
        for(CartDTO tempcart:cartlist)
        {

            if(tempcart==null)
            {
                return "failure";
            }
            orderdto.setProductid(tempcart.getProductId());
            message+="ProductName : "+tempcart.getProductname()+"\n";
            orderdto.setMerchantid(tempcart.getMerchantId());
            orderdto.setProductnumber(tempcart.getQuantity());
            message+="Quantity : "+tempcart.getQuantity()+"\n";
            orderdto.setProductname(tempcart.getProductname());
            orderdto.setImgurl(tempcart.getImgurl());
            orderdto.setPrice(tempcart.getPrice());
            message+="Price For "+tempcart.getProductname()+" : "+tempcart.getPrice()+"\n";
            double taxamount = (tempcart.getPrice()*tempcart.getQuantity() );
            tax+=((taxamount*18)/100);
            orderdto.setOrdernumber(orderid+20);
            orderid+=1;
            orderdto.setTax((taxamount*18)/100);
            orderdto.setTotal(taxamount+orderdto.getPrice());
            total+=(orderdto.getTotal());

            tomerchant=new ToMerchant((int)orderdto.getMerchantid(),(int)orderdto.getProductid(),(int)orderdto.getProductnumber());
            HttpEntity entity = new HttpEntity(tomerchant,headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> out = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            HttpEntity entity1 = new HttpEntity(tempcart,headers1);
            RestTemplate restTemplate1 = new RestTemplate();
            ResponseEntity<String> out1 = restTemplate1.exchange(url1, HttpMethod.DELETE, entity1, String.class);

            service.addOrder(orderdto);

        }
        message+="Tax amount : "+tax+"\n";
        message+="Total : "+total+"\n";
        //System.out.println(message);
        //service.sendEmail(orderdto.getEmailid(),message);
        mailqueue.put(orderdto.getEmailid(),message);
        return "success";
    }


    @GetMapping("/getorder")
    public OrderDTO getOrderById(@RequestParam Integer id)
    {
        return service.getOrderById(id);
    }

    @GetMapping("/merchantorder")
    public List<OrderDTO> merchantOrder(@RequestParam Integer id)
    {
        return service.merchantOrder(id);
    }
    @GetMapping("/userorder")
    public List<OrderDTO> userOrder(@RequestParam Integer id)
    {
        return service.userOrder(id);
    }
}
