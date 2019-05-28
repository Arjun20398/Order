package com.example.Order.CartDTO;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="tomerchant")
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ToMerchant {
    int mid;
    int pid;
    int quantity;

    public ToMerchant(int mid, int pid, int quantity) {
        this.mid = mid;
        this.pid = pid;
        this.quantity = quantity;
    }
    public  ToMerchant()
    {

    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
