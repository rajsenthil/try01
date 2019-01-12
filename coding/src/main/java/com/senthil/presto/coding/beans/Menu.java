package com.senthil.presto.coding.beans;

public class Menu {

    private int id;
    private int restaurantId;
    private String name;
    private MenuType menuType;

    private Item root;

    //TODO: Allow CRUD operations to the menu items
    //      These operations will be done by Restaurant admin, in a access controlled screen.
    //TODO: to find the matching item
    public void find(int id) {}

    //TODO: add the modifier to the menu item
    public void insert(Item item) {}

    //TODO: delete the modifier to the menu item
    public void delete(int id) {}

    public int getId() {
        return id;
    }

    public Menu setId(int id) {
        this.id = id;
        return this;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public Menu setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Menu setName(String name) {
        this.name = name;
        return this;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public Menu setMenuType(MenuType menuType) {
        this.menuType = menuType;
        return this;
    }

    public Item getRoot() {
        return root;
    }

    public Menu setRoot(Item root) {
        this.root = root;
        return this;
    }
}
