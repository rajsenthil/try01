package com.senthil.presto.coding.config;

import com.senthil.presto.coding.boot.Boot;
import com.senthil.presto.coding.dao.H2MenuDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MenuLoader {

    private Logger logger = LoggerFactory.getLogger(MenuLoader.class.getName());

    private static final String DROP_TABLE_MENU = "DROP TABLE Menu;";
    private static final String DROP_TABLE_ITEM = "DROP TABLE Item;";
    private static final String CREATE_MENU_TABLE = "CREATE TABLE IF NOT EXISTS Menu(ID INT AUTO_INCREMENT PRIMARY KEY, RESTAURANT_ID INT, NAME VARCHAR(50), MENU_TYPE VARCHAR(10));";
    private static final String CREATE_MENU_ITEM_TABLE = "CREATE TABLE IF NOT EXISTS Item(ID INT AUTO_INCREMENT PRIMARY KEY, MENU_ID INT, NAME VARCHAR(50), MODIFIER CHAR(1), PARENT_ID INT, foreign key (MENU_ID) references MENU(ID));";

    private H2MenuDao h2MenuDao;

    public MenuLoader() {
        h2MenuDao = new H2MenuDao();
    }


    public void createTables() throws Exception {
        h2MenuDao.executeStatement(CREATE_MENU_TABLE);
        h2MenuDao.executeStatement(CREATE_MENU_ITEM_TABLE);
        logger.info("Created tables...");
    }

    public void populateTables() {
        populateMenuTable();
        populateMenuItemTable();
    }

    private void populateMenuTable() {
        String INSERT_MENU = "INSERT INTO Menu (RESTAURANT_ID, NAME, MENU_TYPE) values (1, 'The Restaurant', 'FOOD')";
    }

    private void populateMenuItemTable() {
    }

    public void dropTables() throws Exception {
        h2MenuDao.executeStatement(DROP_TABLE_ITEM);
        h2MenuDao.executeStatement(DROP_TABLE_MENU);
        logger.info("... and dropped them.");
    }
}
