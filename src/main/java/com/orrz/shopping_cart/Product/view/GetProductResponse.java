package com.orrz.shopping_cart.Product.view;import com.orrz.shopping_cart.Product.model.Product;/** * @Author: Lin_Ya * @Date: 2019-01-31-09:48 * @Version: 1.0 * @Description: 响应类 返回一个商品 */public class GetProductResponse {    private Product product;    public GetProductResponse() {    }    public GetProductResponse(Product product) {        this.product = product;    }    public Product getProduct() {        return product;    }    public void setProduct(Product product) {        this.product = product;    }}