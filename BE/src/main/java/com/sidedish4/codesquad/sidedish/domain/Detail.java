package com.sidedish4.codesquad.sidedish.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class Detail {

    private String topImage;
    private String productDescription;
    private String point;
    private String deliveryInfo;
    private String deliveryFee;
    private String n_price;
    private String s_price;
    private List<ThumbImage> ThumbImages = new ArrayList<>();
    private List<DetailSection> DetailSections = new ArrayList<>();

    @Builder
    public Detail(String topImage, String productDescription, String point, String deliveryInfo, String deliveryFee,
                  String n_price, String s_price, List<ThumbImage> thumbImages, List<DetailSection> detailSections) {
        this.topImage = topImage;
        this.productDescription = productDescription;
        this.point = point;
        this.deliveryInfo = deliveryInfo;
        this.deliveryFee = deliveryFee;
        this.n_price = n_price;
        this.s_price = s_price;
        ThumbImages = thumbImages;
        DetailSections = detailSections;
    }

    public String getTopImage() {
        return topImage;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public String getPoint() {
        return point;
    }

    public String getDeliveryInfo() {
        return deliveryInfo;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public String getN_price() {
        return n_price;
    }

    public String getS_price() {
        return s_price;
    }

    public List<ThumbImage> getThumbImages() {
        return ThumbImages;
    }

    public List<DetailSection> getDetailSections() {
        return DetailSections;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "topImage='" + topImage + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", point='" + point + '\'' +
                ", deliveryInfo='" + deliveryInfo + '\'' +
                ", deliveryFee='" + deliveryFee + '\'' +
                ", n_price='" + n_price + '\'' +
                ", s_price='" + s_price + '\'' +
                ", ThumbImages=" + ThumbImages +
                ", DetailSections=" + DetailSections +
                '}';
    }
}
