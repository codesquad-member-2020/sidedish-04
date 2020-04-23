package com.sidedish4.codesquad.sidedish.domain.entity;

import org.springframework.data.annotation.Id;

public class Delivery {
    @Id
    private Long id;
    private String deliveryType;

    public Delivery(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", deliveryType='" + deliveryType + '\'' +
                '}';
    }
}
