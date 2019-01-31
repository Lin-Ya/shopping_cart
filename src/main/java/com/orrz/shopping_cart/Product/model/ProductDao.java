package com.orrz.shopping_cart.Product.model;import org.springframework.stereotype.Repository;import java.util.List;/** * @Author: Lin_Ya * @Date: 2019-01-31-09:05 * @Version: 1.0 * @Description: 产品 数据交互接口，定义操作： 新增、删除、查找、查找全部 & 更新。 */@Repositorypublic interface ProductDao {    Product save(Product product);    Boolean delete(long id);    Product getById(long id);    List<Product> findAll();    Product update(long id, Product product);}