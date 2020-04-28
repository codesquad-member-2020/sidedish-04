package com.sidedish4.codesquad.sidedish.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class ItemResponseDto {

    private String detail_hash;
    private String image;
    private String alt;
    private List<String> delivery_type;
    private String title;
    private String description;
    private String n_price;
    private String s_price;
    private List<String> badge;

    @Builder
    public ItemResponseDto(String detail_hash, String image, String alt, List<String> delivery_type, String title,
                           String description, String n_price, String s_price, List<String> badge) {
        this.detail_hash = detail_hash;
        this.image = image;
        this.alt = alt;
        this.delivery_type = delivery_type;
        this.title = title;
        this.description = description;
        this.n_price = n_price;
        this.s_price = s_price;
        this.badge = badge;
    }
}
