package com.orrz.shopping_cart.Order.view;/** * @Author: Lin_Ya * @Date: 2019-02-01-16:57 * @Version: 1.0 * @Description: *** */public class UpdateOrderResquest {    private long quantity;    private String status;    private String address;    public UpdateOrderResquest() {    }    public UpdateOrderResquest(long quantity, String status, String address) {        this.quantity = quantity;        this.status = status;        this.address = address;    }    public long getQuantity() {        return quantity;    }    public void setQuantity(long quantity) {        this.quantity = quantity;    }    public String getStatus() {        return status;    }    public void setStatus(String status) {        this.status = status;    }    public String getAddress() {        return address;    }    public void setAddress(String address) {        this.address = address;    }}