package com.orrz.shopping_cart.Order.view.create;import com.orrz.shopping_cart.Order.model.Order;/** * @Author: Lin_Ya * @Date: 2019-02-01-16:31 * @Version: 1.0 * @Description: 创建订单的响应类 */public class CreateOrderResponse {    private Order order;    public CreateOrderResponse() {    }    public CreateOrderResponse(Order order) {        this.order = order;    }    public Order getOrder() {        return order;    }    public void setOrder(Order order) {        this.order = order;    }}