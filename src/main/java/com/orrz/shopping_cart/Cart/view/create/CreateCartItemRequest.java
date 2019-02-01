package com.orrz.shopping_cart.Cart.view.create;/** * @Author: Lin_Ya * @Date: 2019-01-31-16:49 * @Version: 1.0 * @Description: 创建购物车条目的请求类 */public class CreateCartItemRequest {    private long userId;    private long productId;    private long quantity;    public CreateCartItemRequest() {    }    public CreateCartItemRequest(long userId, long productId, long quantity) {        this.userId = userId;        this.productId = productId;        this.quantity = quantity;    }    public long getUserId() {        return userId;    }    public void setUserId(long userId) {        this.userId = userId;    }    public long getProductId() {        return productId;    }    public void setProductId(long productId) {        this.productId = productId;    }    public long getQuantity() {        return quantity;    }    public void setQuantity(long quantity) {        this.quantity = quantity;    }}