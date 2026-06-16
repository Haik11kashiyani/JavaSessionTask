package com.tss.ShopingSystem.Product;

public class products {
    static long counter=0;
    protected long productid;
protected String productName;
    protected double productPrice;
    protected double productOFF;

    public products( String productName, double productPrice, double productOFF) {
        this.productid = counter++;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productOFF = productOFF;
    }

    public long getProductid() {
        return productid;
    }

    public void setProductid(long productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductOFF() {
        return productOFF;
    }

    public void setProductOFF(double productOFF) {
        this.productOFF = productOFF;
    }

}
