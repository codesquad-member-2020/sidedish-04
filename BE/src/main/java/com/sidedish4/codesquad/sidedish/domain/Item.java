package com.sidedish4.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Embedded;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class Item {

    @Id
    private Long id;
    private String image;
    private String title;
    private int n_price;
    private int s_price;
    private String alt;
    private String description;
    @Embedded.Nullable
    private Detail detail;
    private List<Badge> badges;
    private List<Delivery> deliveries;
}



