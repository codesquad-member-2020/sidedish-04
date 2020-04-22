package com.sidedish4.codesquad.sidedish.domain.entity;

import org.springframework.data.relational.core.mapping.Column;

import java.util.List;

public class Detail {
    @Column("product_description")
    private String productDescription;
    private String point;
    private String deliveryInfo;
    private String deliveryFee;
    @Column("detail_section")
    private List<DetailImage> detailSection;
    @Column("thumb_image")
    private List<ThumbImage> thumbImage;

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getDeliveryInfo() {
        return deliveryInfo;
    }

    public void setDeliveryInfo(String deliveryInfo) {
        this.deliveryInfo = deliveryInfo;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "productDescription='" + productDescription + '\'' +
                ", point='" + point + '\'' +
                ", deliveryInfo='" + deliveryInfo + '\'' +
                ", deliveryFee='" + deliveryFee + '\'' +
                '}';
    }
}
