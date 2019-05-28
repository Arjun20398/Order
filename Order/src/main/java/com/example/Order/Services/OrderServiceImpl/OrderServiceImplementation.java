package com.example.Order.Services.OrderServiceImpl;

import com.example.Order.ConvertToPDF.ConvertToPdf;
import com.example.Order.Entity.Order;
import com.example.Order.Model.OrderDTO;
import com.example.Order.Repository.OrderRepository;
import com.example.Order.Services.OrderServiceInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImplementation  implements OrderServiceInterface {

    @Autowired
    private OrderRepository orderrepo;

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public String addOrder(OrderDTO order) {
        Order neworder = new Order();
        BeanUtils.copyProperties(order,neworder);
        orderrepo.save(neworder);
        System.out.println(neworder);
        return "order added";
    }

    @Override
    public OrderDTO getOrderById(Integer id) {
        Query query = new Query();
        query.addCriteria(Criteria.where("ordernumber").is(id));
        OrderDTO order = new OrderDTO();
        BeanUtils.copyProperties(mongoTemplate.findOne(query,Order.class),order);
        return order;
    }

    @Override
    public List<OrderDTO> merchantOrder(Integer merchantid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("merchantid").is(merchantid));
        List<Order> result = mongoTemplate.find(query,Order.class);
        List<OrderDTO> temp = new ArrayList<>();
        for(Order res:result)
        {
            OrderDTO temp1 = new OrderDTO();
            BeanUtils.copyProperties(res,temp1);
            temp.add(temp1);
        }
        return temp;
    }

    @Override
    public Long getsize()
    {
        return mongoTemplate.getCollection("E_commerce_order").countDocuments();
    }

    @Override
    public List<OrderDTO> userOrder(Integer userid) {
        Query query = new Query();
        query.addCriteria(Criteria.where("userid").is(userid));
        List<Order> result = mongoTemplate.find(query,Order.class);
        List<OrderDTO> temp = new ArrayList<>();
        for(Order res:result)
        {
            OrderDTO temp1 = new OrderDTO();
            BeanUtils.copyProperties(res,temp1);
            temp.add(temp1);
        }
        return temp;
    }




    public void sendEmail(String email,String message)
    {
        ConvertToPdf tempvar = new ConvertToPdf(email,message);
        tempvar.makeemail();
    }
}
