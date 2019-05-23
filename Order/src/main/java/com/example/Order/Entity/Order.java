package com.example.Order.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document(collection = "E_commerce_order")
public class Order {
    @Id
    Integer ordernumber;
    Date orderdate;
    Integer userid;
    Integer merchantid;
    String paymentoption;
    String billingaddress;
    String shipingaddress;
    Integer productid;
    Integer productnumber;
    double price;
    double tax;
    double total;

    public Order(Date orderdate, Integer ordernumber, Integer userid, Integer merchantid,
                 String paymentoption, String billingaddress, String shipingaddress, Integer productid,
                 Integer productnumber, double price, double tax, double total) {
        this.orderdate = orderdate;
        this.ordernumber = ordernumber;
        this.userid = userid;
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

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getMerchantid() {
        return merchantid;
    }

    public void setMerchantid(Integer merchantid) {
        this.merchantid = merchantid;
    }

    public String getPaymentoption() {
        return paymentoption;
    }

    public void setPaymentoption(String paymentoption) {
        this.paymentoption = paymentoption;
    }

    public String getBillingaddress() {
        return billingaddress;
    }

    public void setBillingaddress(String billingaddress) {
        this.billingaddress = billingaddress;
    }

    public String getShipingaddress() {
        return shipingaddress;
    }

    public void setShipingaddress(String shipingaddress) {
        this.shipingaddress = shipingaddress;
    }

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public Integer getProductnumber() {
        return productnumber;
    }

    public void setProductnumber(Integer productnumber) {
        this.productnumber = productnumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
