package com.orrz.shopping_cart.User.model;import org.springframework.stereotype.Repository;import java.util.List;/** * @Author: Lin_Ya * @Date: 2019-01-29-12:08 * @Version: 1.0 * @Description: UserDao 接口，用于定义 与 User相关的方法 */@Repositorypublic interface UserDao {    User getById(long id);    List<User> findAll();    User save(User user);    User update(long id, User user);    Boolean delete(long id);}