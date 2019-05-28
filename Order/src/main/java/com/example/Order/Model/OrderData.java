package com.example.Order.Model;

import java.util.Date;

public class OrderData {

    Date orderdate;
    Integer userid;
    String productname;
    String emailid;
    Integer merchantid;
    String paymentoption;
    String billingaddress;
    String shipingaddress;
    Integer productid;
    String imgurl;
    Integer productnumber;
    double price;

    public OrderData(Date orderdate, Integer userid, String productname,String imgurl, String emailid, Integer merchantid,
                     String paymentoption, String billingaddress, String shipingaddress, Integer productid,
                     Integer productnumber, double price) {
        this.orderdate = orderdate;
        this.userid = userid;
        this.productname = productname;
        this.emailid = emailid;
        this.merchantid = merchantid;
        this.paymentoption = paymentoption;
        this.billingaddress = billingaddress;
        this.shipingaddress = shipingaddress;
        this.productid = productid;
        this.productnumber = productnumber;
        this.price = price;
    }

    public OrderData(){}

}
