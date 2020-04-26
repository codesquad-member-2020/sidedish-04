package com.sidedish4.codesquad.sidedish.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Getter
public class Menu {

    @Id
    private Long id;
    private String name;
    private List<Item> items = new ArrayList<>();

    @Builder
    public Menu(String name, List<Item> items) {
        this.name = name;
        this.items = items;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", items=" + items +
                '}';
    }

    public void add(Item item) {
        items.add(item);
    }
}
