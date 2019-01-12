package com.senthil.presto.coding.beans;

import java.util.Objects;
import java.util.Set;

public class Item {
    private int id;
    private String name;
    private Set<Item> modifiers;
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

    public Set<Item> getModifiers() {
        return modifiers;
    }

    public Item setModifiers(Set<Item> modifiers) {
        this.modifiers = modifiers;
        return this;
    }

    public boolean isModifier() {
        return isModifier;
    }

    public Item setModifier(boolean modifier) {
        isModifier = modifier;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
            if (!(o instanceof Item)) {
            return false;
        }
        Item item = (Item) o;
        return id == item.id && Objects.equals(name, item.name) && Objects.equals(isModifier, item.isModifier) && Objects.equals(isModifier, item.isModifier);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isModifier);
    }
}
