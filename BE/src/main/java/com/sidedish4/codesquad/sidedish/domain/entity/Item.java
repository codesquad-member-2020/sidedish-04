package com.sidedish4.codesquad.sidedish.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Embedded;

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
    private Set<ItemBadge> badges;
    @Column("delivery")
    private Set<ItemDelivery> deliveries;

    @Embedded.Nullable
    private Detail detail;


    public Long getId() {
        return id;
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

    public Detail getDetail() {
        return detail;
    }

    public void setDetail(Detail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", detailHash='" + detailHash + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", alt='" + alt + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", nPrice='" + nPrice + '\'' +
                ", sPrice='" + sPrice + '\'' +
                ", detail=" + detail +
                '}';
    }
}
