package com.example.Order.CartDTO;


public class ToCart {
    private int productId;
    private int merchnantId;
    private int quantity;
    private int userId;
    private String productname;
    private String imgurl;
    private int price;


    ToCart(){}

    public ToCart(int productId, int merchnantId, int quantity, int userId, String productname, String imgurl, int price) {
        this.productId = productId;
        this.merchnantId = merchnantId;
        this.quantity = quantity;
        this.userId = userId;
        this.productname = productname;
        this.imgurl = imgurl;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getMerchnantId() {
        return merchnantId;
    }

    public void setMerchnantId(int merchnantId) {
        this.merchnantId = merchnantId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
