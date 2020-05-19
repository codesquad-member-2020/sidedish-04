package com.sidedish4.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Detail {
    private String top_image;
    private List<String> thumb_images = new ArrayList<>();
    private String product_description;
    private String point;
    private String delivery_info;
    private String delivery_fee;
    private List<String> prices = new ArrayList<>();
    private List<String> detail_section = new ArrayList<>();

    public void addPrices(String n_price,String s_price) {
        if (n_price != null){
            this.prices.add(n_price);
        }
        this.prices.add(s_price);
    }
}
