package com.sidedish4.codesquad.sidedish.service;

import com.google.gson.Gson;
import com.sidedish4.codesquad.sidedish.domain.*;
import com.sidedish4.codesquad.sidedish.web.dto.EachDetailResponseDto;
import com.sidedish4.codesquad.sidedish.web.dto.ItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SideDishService {

    private final MenuRepository menuRepository;
    private final RestTemplate restTemplate;
    private Logger logger = LoggerFactory.getLogger(SideDishService.class);

    public Menu saveItem(String menu, String hash, String menuName) {
        String detail = "detail";
        String url = "https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/"+menu+"/"+hash;
        String detailUrl = "https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/"+detail+"/"+hash;

        //each
        String main = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        ItemResponseDto itemResponseDto = gson.fromJson(main, ItemResponseDto.class);

        String detailJson = restTemplate.getForObject(detailUrl, String.class);
        EachDetailResponseDto eachDetailResponseDto = gson.fromJson(detailJson, EachDetailResponseDto.class);

        Menu amenu = menuRepository.findByName(menuName).orElseThrow(() ->
                new IllegalArgumentException("해당 메뉴는 없습니다. menuName : "+menuName));

        List<Badge> badges = new ArrayList<>();
        if (itemResponseDto.getBadge() != null) itemResponseDto.getBadge().forEach(b -> badges.add(new Badge(b)));
        List<Delivery> deliveries = new ArrayList<>();
        if (itemResponseDto.getDelivery_type() != null) itemResponseDto.getDelivery_type().forEach(d -> deliveries.add(new Delivery(d)));
        List<ThumbImage> thumbImages = new ArrayList<>();
        logger.info("eachDetailResponseDto : {}", eachDetailResponseDto);
        if (eachDetailResponseDto.getData().getThumb_images() != null) eachDetailResponseDto.getData().getThumb_images().forEach(t -> thumbImages.add(new ThumbImage(t)));
        List<DetailSection> detailSections = new ArrayList<>();
        if (eachDetailResponseDto.getData().getDetail_section() != null) eachDetailResponseDto.getData().getDetail_section().forEach(d -> detailSections.add(new DetailSection(d)));

        Item item = Item.builder()
                .alt(itemResponseDto.getAlt())
                .badges(badges)
                .deliveries(deliveries)
                .delivery_fee(eachDetailResponseDto.getData().getDelivery_fee())
                .delivery_info(eachDetailResponseDto.getData().getDelivery_info())
                .description(itemResponseDto.getDescription())
                .detailSections(detailSections)
                .image(itemResponseDto.getImage())
                .n_price(itemResponseDto.getN_price())
                .s_price(itemResponseDto.getS_price())
                .point(eachDetailResponseDto.getData().getPoint())
                .thumbImages(thumbImages)
                .title(itemResponseDto.getTitle())
                .top_image(eachDetailResponseDto.getData().getTop_image())
                .build();

        amenu.getItems().add(item);

        return menuRepository.save(amenu);
    }


    public Menu findById(Long id) {
        return menuRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 메뉴가 없습니다. id = " +id));
    };
}
