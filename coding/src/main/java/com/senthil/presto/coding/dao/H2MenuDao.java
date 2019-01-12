package com.senthil.presto.coding.dao;

import com.senthil.presto.coding.beans.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class H2MenuDao {

    Logger logger = LoggerFactory.getLogger(H2MenuDao.class.getName());

    public Menu getMenu(int id, String type) {

        return new Menu();
    }

    public void executeStatement(String sql) throws Exception{
        Statement statement = getConnection().createStatement();
        statement.execute(sql);
    }

    Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection("jdbc:h2:tcp://127.0.1.1:9092/~/menu", "sa", "");
            logger .info("Connection Established: "+ conn.getMetaData().getDatabaseProductName() + "/" + conn.getCatalog());
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}
