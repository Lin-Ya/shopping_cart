package com.orrz.shopping_cart.User.view;import com.orrz.shopping_cart.User.model.User;/** * @Author: Lin_Ya * @Date: 2019-01-29-14:56 * @Version: 1.0 * @Description: 用于返回 User 信息 */public class UserView {    private long id;    private String name;    private String phoneNumber;    public UserView(User user) {        id = user.getId();        name = user.getName();        phoneNumber = user.getPhoneNumber();    }    public long getId() {        return id;    }    public void setId(long id) {        this.id = id;    }    public String getName() {        return name;    }    public void setName(String name) {        this.name = name;    }    public String getPhoneNumber() {        return phoneNumber;    }    public void setPhoneNumber(String phoneNumber) {        this.phoneNumber = phoneNumber;    }}