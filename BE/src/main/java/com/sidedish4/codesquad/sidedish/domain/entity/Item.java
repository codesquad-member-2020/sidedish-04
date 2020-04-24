package com.sidedish4.codesquad.sidedish.domain.entity;

import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.HashSet;
import java.util.Set;

public class Item {
    @Id
    private Long id;
    private String detailHash;
    @Column("item_image")
    private String imageUrl;
    private String alt;
    private String title;
    private String description;
    @Column("normal_price")
    private String nPrice;
    @Column("sale_price")
    private String sPrice;
    @Column("badge")
    private Set<ItemBadge> badges = new HashSet<>();
    @Column("delivery")
    private Set<ItemDelivery> deliveries = new HashSet<>();
//
//    @Embedded.Empty
//    private Detail detail;

    public void addBadge(Badge badge) {
        ItemBadge itemBadge = new ItemBadge(badge.getId());
        this.badges.add(itemBadge);
    }

    public void addDelivery(Delivery delivery) {
        ItemDelivery itemDelivery = new ItemDelivery(delivery.getId());
        this.deliveries.add(itemDelivery);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetailHash() {
        return detailHash;
    }

    public void setDetailHash(String detailHash) {
        this.detailHash = detailHash;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getnPrice() {
        return nPrice;
    }

    public void setnPrice(String nPrice) {
        this.nPrice = nPrice;
    }

    public String getsPrice() {
        return sPrice;
    }

    public void setsPrice(String sPrice) {
        this.sPrice = sPrice;
    }

    public Set<ItemBadge> getBadges() {
        return badges;
    }

    public void setBadges(Set<ItemBadge> badges) {
        this.badges = badges;
    }

    public Set<ItemDelivery> getDeliveries() {
        return deliveries;
    }

    public void setDeliveries(Set<ItemDelivery> deliveries) {
        this.deliveries = deliveries;
    }
}
