package com.example.Order.Entity;

import org.springframework.context.annotation.Bean;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.Generated;
import java.util.Date;

@Document(collection = "E_commerce_order")
public class Order {
    @Id
    Long ordernumber;
    Date orderdate;//
    Integer userid;//
    String productname;
    String emailid;
    Integer merchantid;
    String paymentoption;
    String billingaddress;
    String shipingaddress;
    Integer productid;
    Integer productnumber;
    String imurl;
    double price;
    double tax;
    double total;

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }
    @Bean
    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public Order(Long ordernumber, Date orderdate, Integer userid, String productname,String imgurl, String emailid,
                 Integer merchantid, String paymentoption, String billingaddress, String shipingaddress,
                 Integer productid, Integer productnumber, double price, double tax, double total) {
        this.ordernumber = ordernumber;
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
        this.tax = tax;
        this.total = total;
    }

    public Order() {
    }
    @Bean
    public String getImurl() {
        return imurl;
    }

    public void setImurl(String imurl) {
        this.imurl = imurl;
    }
    @Bean
    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }
    @Bean
    public Long getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Long ordernumber) {
        this.ordernumber = ordernumber;
    }
    @Bean
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    @Bean
    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    @Bean
    public String getPaymentoption() {
        return paymentoption;
    }

    public void setPaymentoption(String paymentoption) {
        this.paymentoption = paymentoption;
    }

    @Bean
    public String getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    @Bean
    public String getShipingaddress() {
        return shipingaddress;
    }

    public void setShipingaddress(String shipingaddress) {
        this.shipingaddress = shipingaddress;
    }

    @Bean
    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    @Bean
    public Integer getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(Integer productnumber) {
        this.productnumber = productnumber;
    }

    @Bean
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Bean
    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Bean
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
