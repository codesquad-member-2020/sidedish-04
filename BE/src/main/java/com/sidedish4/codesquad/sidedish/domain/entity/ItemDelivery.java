package com.sidedish4.codesquad.sidedish.domain.entity;

import org.springframework.data.relational.core.mapping.Column;

public class ItemDelivery {
    @Column("delivery")
    private Long deliveryId;

    public ItemDelivery(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    @Override
    public String toString() {
        return "ItemDelivery{" +
                "deliveryId=" + deliveryId +
                '}';
    }
}
