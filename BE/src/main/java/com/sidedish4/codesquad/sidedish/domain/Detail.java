package com.sidedish4.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@NoArgsConstructor
@RequiredArgsConstructor
@Getter
public class Detail {

    private String topImage;
    private String productDescription;
    private String point;
    private String deliveryInfo;
    private String deliveryFee;
    private String n_price;
    private String s_price;
    private List<ThumbImage> ThumbImages;
    private List<DetailSection> DetailSections;

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
