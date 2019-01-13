package com.senthil.presto.coding.config;

import com.senthil.presto.coding.beans.Item;
import com.senthil.presto.coding.beans.Menu;
import com.senthil.presto.coding.beans.MenuType;
import com.senthil.presto.coding.boot.Boot;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

@Disabled
public class MenuLoaderTest {

    private Logger logger = LoggerFactory.getLogger(MenuLoaderTest.class.getName());

     @Disabled
//    @Test
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


    @Disabled
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

    @Disabled
//    @Test
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
        Item food = new Item().setId(1).setModifier(false).setName("Food");
        Item sandwich = new Item().setId(2).setModifier(true).setName("Sandwiches");
        Item appetizers = new Item().setId(4).setModifier(false).setName("appetizers");
        Item desserts = new Item().setId(5).setModifier(false).setName("desserts");

        menu.setId(0).setMenuType(MenuType.FOOD).setName("Foods").setItem(food);

        Set<Item> items = new HashSet<>();
        items.add(appetizers);
        items.add(sandwich);
        items.add(desserts);

        Item chickenSandwich = new Item().setId(6).setModifier(false).setName("Chicken Sandwich");
        Item turkeySandwich = new Item().setId(7).setModifier(false).setName("Turkey Sandwich");
        Item tunaSandwich = new Item().setId(8).setModifier(false).setName("Tuna Sandwich");
        Set<Item> sandwichModifiers = new HashSet<>();
        sandwichModifiers.add(chickenSandwich);
        sandwichModifiers.add(turkeySandwich);
        sandwichModifiers.add(tunaSandwich);
        sandwich.setModifiers(sandwichModifiers);

        Item cheese = new Item().setId(9).setModifier(true).setName("cheese");
        Item lettuce = new Item().setId(10).setModifier(false).setName("lettuce");
        Item tomato = new Item().setId(11).setModifier(false).setName("tomato");
        Set<Item> modifiers = new HashSet<>();
        modifiers.add(cheese);
        modifiers.add(lettuce);
        modifiers.add(tomato);

        Item sandWichaddon = new Item().setId(3).setModifier(true).setName("Sandwich addons");

        sandWichaddon.setModifiers(modifiers);

        Item american = new Item().setId(12).setModifier(false).setName("American Cheese");
        Item swiss = new Item().setId(13).setModifier(false).setName("Swiss Cheese");
        Item parmesan = new Item().setId(14).setModifier(false).setName("Parmesan Cheese");
        Set<Item> cheeseModifiers = new HashSet<>();
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
