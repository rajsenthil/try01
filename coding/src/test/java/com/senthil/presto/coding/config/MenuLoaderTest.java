package com.senthil.presto.coding.config;

import com.senthil.presto.coding.beans.Item;
import com.senthil.presto.coding.beans.Menu;
import com.senthil.presto.coding.beans.MenuType;
import com.senthil.presto.coding.boot.Boot;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

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

//    @Test
    public void testDropTables() {
        try {
            MenuLoader menuLoader = new MenuLoader();
            menuLoader.dropTables();
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    public void testLoadMenuData() {
        logger.info("Loading test data...");
        Menu menu = getTestMenu();
        try {
            MenuLoader menuLoader = new MenuLoader();
            menuLoader.populateTables(menu);
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }


    private Menu getTestMenu() {
        Menu menu = new Menu();
        Item food = new Item().setId(1).setIsModifier(false).setName("Food");
        Item sandwich = new Item().setId(2).setIsModifier(true).setName("Sandwiches");
        Item appetizers = new Item().setId(4).setIsModifier(false).setName("appetizers");
        Item desserts = new Item().setId(5).setIsModifier(false).setName("desserts");

        menu.setId(0).setMenuType(MenuType.FOOD).setName("Foods").setItem(food);

        List<Item> items = new ArrayList();
        items.add(appetizers);
        items.add(sandwich);
        items.add(desserts);

        Item chickenSandwich = new Item().setId(6).setIsModifier(false).setName("Chicken Sandwich");
        Item turkeySandwich = new Item().setId(7).setIsModifier(false).setName("Turkey Sandwich");
        Item tunaSandwich = new Item().setId(8).setIsModifier(false).setName("Tuna Sandwich");
        List<Item> sandwichModifiers = new ArrayList();
        sandwichModifiers.add(chickenSandwich);
        sandwichModifiers.add(turkeySandwich);
        sandwichModifiers.add(tunaSandwich);
        sandwich.setModifiers(sandwichModifiers);

        Item cheese = new Item().setId(9).setIsModifier(true).setName("cheese");
        Item lettuce = new Item().setId(10).setIsModifier(false).setName("lettuce");
        Item tomato = new Item().setId(11).setIsModifier(false).setName("tomato");
        List<Item> modifiers = new ArrayList();
        modifiers.add(cheese);
        modifiers.add(lettuce);
        modifiers.add(tomato);

        Item sandWichaddon = new Item().setId(3).setIsModifier(true).setName("Sandwich addons");

        sandWichaddon.setModifiers(modifiers);

        Item american = new Item().setId(12).setIsModifier(false).setName("American Cheese");
        Item swiss = new Item().setId(13).setIsModifier(false).setName("Swiss Cheese");
        Item parmesan = new Item().setId(14).setIsModifier(false).setName("Parmesan Cheese");
        List<Item> cheeseModifiers = new ArrayList();
        cheeseModifiers.add(american);
        cheeseModifiers.add(swiss);
        cheeseModifiers.add(parmesan);
        cheese.setModifiers(cheeseModifiers);

        chickenSandwich.setModifiers(modifiers);
        tunaSandwich.setModifiers(modifiers);
        tunaSandwich.setModifiers(modifiers);

        food.setModifiers(items);
        return menu;
    }
}
