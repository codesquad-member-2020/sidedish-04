package com.sidedish4.codesquad.sidedish.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
public class Item {

    @Id
    private Long id;
    private String image;
    private String title;
    private String n_price;
    private String s_price;
    private String alt;
    private String description;
    @Embedded.Nullable
    private Detail detail;
    private List<Badge> badges = new ArrayList<>();
    private List<Delivery> deliveries = new ArrayList<>();

    @Builder
    public Item(String image, String title, String n_price, String s_price, String alt, String description, Detail detail, List<Badge> badges, List<Delivery> deliveries) {
        this.image = image;
        this.title = title;
        this.n_price = n_price;
        this.s_price = s_price;
        this.alt = alt;
        this.description = description;
        this.detail = detail;
        this.badges = badges;
        this.deliveries = deliveries;
    }

    public Long getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getN_price() {
        return n_price;
    }

    public String getS_price() {
        return s_price;
    }

    public String getAlt() {
        return alt;
    }

    public String getDescription() {
        return description;
    }

    public Detail getDetail() {
        return detail;
    }

    public List<Badge> getBadges() {
        return badges;
    }

    public List<Delivery> getDeliveries() {
        return deliveries;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", n_price='" + n_price + '\'' +
                ", s_price='" + s_price + '\'' +
                ", alt='" + alt + '\'' +
                ", description='" + description + '\'' +
                ", detail=" + detail +
                ", badges=" + badges +
                ", deliveries=" + deliveries +
                '}';
    }
}



