package com.senthil.presto.coding.dao;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.SQLException;

public class H2MenuDaoTest {
    private Logger logger = LoggerFactory.getLogger(H2MenuDaoTest.class.getName());

    @Test
    public void testH2Connection() {

        H2MenuDao h2MenuDao = new H2MenuDao();
        Connection conn = h2MenuDao.getConnection();
        try {
            conn.close();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void queryItemss() {
        H2MenuDao h2MenuDao = new H2MenuDao();
        try {
            h2MenuDao.items(1);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
