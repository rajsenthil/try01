package com.senthil.presto.coding.beans;

import java.util.List;

public class Item {
    private int id;
    private String name;
    private List<Item> modifiers;
    private boolean isModifier;

    public int getId() {
        return id;
    }

    public Item setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public List<Item> getModifiers() {
        return modifiers;
    }

    public Item setModifiers(List<Item> modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    public boolean isModifier() {
        return isModifier;
    }

    public Item setIsModifier(boolean isModifier) {
        this.isModifier = isModifier;
        return this;
    }
}
