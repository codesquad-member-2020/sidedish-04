package com.sidedish4.codesquad.sidedish.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class DetailResponseDto {

    private String top_image;
    private List<String> thumb_images;
    private String product_description;
    private String point;
    private String delivery_info;
    private String delivery_fee;
    private List<String> prices;
    private List<String> detail_section;
}
