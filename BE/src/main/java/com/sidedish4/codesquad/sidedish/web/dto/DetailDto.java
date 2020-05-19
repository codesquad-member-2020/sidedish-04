package com.sidedish4.codesquad.sidedish.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class DetailDto {

    private String top_image;
    private List<String> thumb_images;
    private String product_description;
    private String point;
    private String delivery_info;
    private String delivery_fee;
    private List<String> prices;
    private List<String> detail_section;

    @Builder
    public DetailDto(String top_image, String product_description, String point, String delivery_info, String delivery_fee,
                     List<String> thumb_images, List<String> prices, List<String> detail_section) {
        this.top_image = top_image;
        this.product_description = product_description;
        this.point = point;
        this.delivery_info = delivery_info;
        this.delivery_fee = delivery_fee;
        this.thumb_images = thumb_images;
        this.prices = prices;
        this.detail_section = detail_section;
    }
}
