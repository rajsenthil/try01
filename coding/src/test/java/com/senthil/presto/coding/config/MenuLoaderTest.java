package com.senthil.presto.coding.config;

import com.senthil.presto.coding.boot.Boot;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuLoaderTest {

    private Logger logger = LoggerFactory.getLogger(MenuLoaderTest.class.getName());

    @Test
    public void testCreateTable() {
        try {
            logger.info("Starting h2 db...");
            Boot boot = new Boot();
            boot.startH2Server();
            logger.info("Started h2 db.");

            MenuLoader menuLoader = new MenuLoader();
            menuLoader.createTables();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testDropTables() {
        try {
            MenuLoader menuLoader = new MenuLoader();
            menuLoader.dropTables();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

}
