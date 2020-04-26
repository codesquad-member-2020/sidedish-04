package com.sidedish4.codesquad.sidedish.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@ToString
public class Item {

    @Id
    private Long id;
    private String image;
    private String title;
    private String n_price;
    private String s_price;
    private String alt;
    private String description;
    private String top_image;
    private String point;
    private String delivery_info;
    private String delivery_fee;
    private List<Badge> badges = new ArrayList<>();
    private List<Delivery> deliveries = new ArrayList<>();
    private List<ThumbImage> thumbImages = new ArrayList<>();
    private List<DetailSection> detailSections = new ArrayList<>();

    @Builder
    public Item(String image, String title, String n_price, String s_price, String alt, String description, String top_image, String point, String delivery_info,
                String delivery_fee, List<Badge> badges, List<Delivery> deliveries, List<ThumbImage> thumbImages, List<DetailSection> detailSections) {
        this.image = image;
        this.title = title;
        this.n_price = n_price;
        this.s_price = s_price;
        this.alt = alt;
        this.description = description;
        this.top_image = top_image;
        this.point = point;
        this.delivery_info = delivery_info;
        this.delivery_fee = delivery_fee;
        this.badges = badges;
        this.deliveries = deliveries;
        this.thumbImages = thumbImages;
        this.detailSections = detailSections;
    }
}



