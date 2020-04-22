package com.sidedish4.codesquad.sidedish.domain;

import org.springframework.data.annotation.Id;

import java.util.List;

public class Menu {
    @Id
    private Long id;
    private String menuName;

    private List<Item> items;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", menuName='" + menuName + '\'' +
                ", items=" + items +
                '}';
    }
}
