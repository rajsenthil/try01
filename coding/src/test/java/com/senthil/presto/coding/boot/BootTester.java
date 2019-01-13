package com.senthil.presto.coding.boot;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senthil.presto.coding.beans.Menu;
import com.senthil.presto.coding.dao.H2MenuDao;
import org.glassfish.jersey.client.ClientConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;

public class BootTester {
    private Logger logger = LoggerFactory.getLogger(BootTester.class.getName());

    @Test
    public void testH2Boot() {
        Boot boot = new Boot();
        try {
            //1. Start h2 server
            boot.startH2Server();
            //2. load menu data
//            boot.bootMenus();
            H2MenuDao h2MenuDao = new H2MenuDao();
            try {
                Menu menu = h2MenuDao.getMenu(0,1);
//                h2MenuDao.items(1);

                String path = "dbMenu.json";

                File file = new File(path);
                ObjectMapper mapper = new ObjectMapper();
                try {
                    mapper.writeValue(file, menu);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testJettyBoot() {
        Boot boot = new Boot();
        try {
            logger.info("testing the jetty server");
            boot.startJettyServer();
        }catch (Exception ex) {
            logger.error(ex.getMessage());
            ex.printStackTrace();
            try {
                boot.stopJettyServer();
            } catch (Exception e) {
                logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
