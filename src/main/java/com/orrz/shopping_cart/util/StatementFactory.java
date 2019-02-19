package com.orrz.shopping_cart.util;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @Author: Lin_Ya
 * @Date: 2019-02-19-10:47
 * @Version: 1.0
 * @Description: Statement 是 SQL里面的一个包，没有办法直接声明成Component，所以需要用工厂模式生成可以注入的依赖对象
 * 本类用于实现连接数据库
 */

@Component("statement")
public class StatementFactory implements FactoryBean {
    // TODO: 把数据库地址抽离出来，放到配置文件中
    public static final String DB_PATH = "jdbc:sqlite:resources/sample.db";

    @Override
    public boolean isSingleton() {
        return true;
    }

    /*
    1. 创建连接（传入数据库地址）
    2. 创建 statement
    3. 设置查询时间的最大值
     */
    @Override
    public Object getObject() throws Exception {
        Connection connection = DriverManager.getConnection(DB_PATH);
        Statement statement = connection.createStatement();
        statement.setQueryTimeout(30);
        return statement;
    }

    @Override
    public Class<?> getObjectType() {
        return Statement.class;
    }
}
