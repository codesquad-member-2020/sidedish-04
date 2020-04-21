package com.sidedish4.codesquad.sidedish.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

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
    private String n_sprice;
    private String s_sprice;
    private List<thumbImage> thumbImages;
    private List<detailSection> detailSections;

}
