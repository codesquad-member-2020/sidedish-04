package com.sidedish4.codesquad.sidedish.domain.entity;

import org.springframework.data.annotation.Id;

public class Delivery {
    @Id
    private Long id;
    private String deliveryType;
}
