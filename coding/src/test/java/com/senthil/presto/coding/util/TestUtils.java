package com.senthil.presto.coding.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.senthil.presto.coding.beans.Item;
import com.senthil.presto.coding.beans.Menu;
import com.senthil.presto.coding.beans.MenuType;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestUtils {

    @Test
    public void testWriteJson() {

        Menu menu = new Menu();
        Item food = new Item().setId(1).setIsModifier(false).setName("Food");
        Item sandwich = new Item().setId(2).setIsModifier(true).setName("Sandwiches");
        Item appetizers = new Item().setId(4).setIsModifier(false).setName("appetizers");
        Item desserts = new Item().setId(5).setIsModifier(false).setName("desserts");

        menu.setId(0).setMenuType(MenuType.FOOD).setName("Foods").setRoot(food);

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

        String path = "menu.json";

        File file = new File(path);
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, menu);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
