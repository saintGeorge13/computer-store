package com.cy.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.unit.DataSize;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {
    @Autowired //自动装配
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    //数据库连接池：Hikari，管理数据库连接对象
    @Test
    void getConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }
}
