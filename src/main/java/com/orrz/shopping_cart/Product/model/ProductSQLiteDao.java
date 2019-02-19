package com.orrz.shopping_cart.Product.model;

import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * @Author: Lin_Ya
 * @Date: 2019-02-19-14:42
 * @Version: 1.0
 * @Description: ***
 */

@Component("ProductSQLiteDao")
public class ProductSQLiteDao implements ProductDao {
    private Statement statement;

    public ProductSQLiteDao(Statement statement) {
        this.statement = statement;

        // 测试连接
//        try {
//            ResultSet rs = statement.executeQuery("SELECT * FROM `Product`");
//            while (rs.next()) {
//                System.out.println(rs.getString("name"));
//            }
//        } catch (SQLException e) {
//            System.out.println("Failed to query product from DB.");
//            e.printStackTrace();
//        }
    }

    @Override
    public Product save(Product product) {
        try {
            String name = product.getName();
            String description = product.getDescription();
            double price = product.getPrice();
            // 这里记得要给 text 添加单引号！
            String sql = "INSERT INTO Product (name,description,price) VALUES ('" + name + "','" + description + "'," + price + ")";
            // 执行 SQL语句
            statement.executeUpdate(sql);
            // 获取自动生成的主键
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                int id = rs.getInt(1);
                product.setId(id);
                return product;
            }
        } catch (SQLException e) {
            System.out.println("Failed to query product from DB. Here is the error message:");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public Boolean delete(long id) {
        System.out.println("进行删除操作，目标是 id = " + id);
        try {
            String sql = "DELETE FROM Product WHERE id = " + id;
            System.out.println(sql);
            // 影响的行号
            int row = statement.executeUpdate(sql);
            // 因为这里只进行一个商品的删除操作，所以 row 应该是 1 / 0
            return row == 1;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product getById(long id) {
        try {
            // 构造SQL查询语句，然后执行
            String query = "SELECT * FROM `product` WHERE id = " + id;
            System.out.println("开始执行查询： " + query);
            ResultSet rs = statement.executeQuery(query);

            // 根据结果构造 Product 对象。然后返回
            if (rs.next()) {
                Product product = new Product(
                        rs.getString("name"),
                        rs.getString("description"),
                        rs.getDouble("price")
                );
                product.setId(id);
                return product;
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Failed to query product from DB.");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product update(long id, Product product) {
        return null;
    }
}
