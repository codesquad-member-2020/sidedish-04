package com.sidedish4.codesquad.sidedish.service;

import com.google.gson.Gson;
import com.sidedish4.codesquad.sidedish.domain.*;
import com.sidedish4.codesquad.sidedish.web.dto.EachDetailResponseDto;
import com.sidedish4.codesquad.sidedish.web.dto.MainResponseDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SideDishService {

    private final MenuRepository menuRepository;
    private final RestTemplate restTemplate;
    private Logger logger = LoggerFactory.getLogger(SideDishService.class);

    public Menu saveItem(String menu, String hash, String menuName) {
        String detail = "detail";
        String url = "https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/" + menu + "/" + hash;
        String detailUrl = "https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/" + detail + "/" + hash;

        //each
        String main = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        MainResponseDto mainResponseDto = gson.fromJson(main, MainResponseDto.class);

        String detailJson = restTemplate.getForObject(detailUrl, String.class);
        EachDetailResponseDto eachDetailResponseDto = gson.fromJson(detailJson, EachDetailResponseDto.class);

        Menu amenu = menuRepository.findByName(menuName).orElseThrow(() ->
                new IllegalArgumentException("해당 메뉴는 없습니다. menuName : " + menuName));

        List<Badge> badges = new ArrayList<>();
        if (mainResponseDto.getBadge() != null) mainResponseDto.getBadge().forEach(b -> badges.add(new Badge(b)));
        List<Delivery> deliveries = new ArrayList<>();
        if (mainResponseDto.getDelivery_type() != null)
            mainResponseDto.getDelivery_type().forEach(d -> deliveries.add(new Delivery(d)));
        List<ThumbImage> thumbImages = new ArrayList<>();
        logger.info("eachDetailResponseDto : {}", eachDetailResponseDto);
        if (eachDetailResponseDto.getData().getThumb_images() != null)
            eachDetailResponseDto.getData().getThumb_images().forEach(t -> thumbImages.add(new ThumbImage(t)));
        List<DetailSection> detailSections = new ArrayList<>();
        if (eachDetailResponseDto.getData().getDetail_section() != null)
            eachDetailResponseDto.getData().getDetail_section().forEach(d -> detailSections.add(new DetailSection(d)));

        Item item = Item.builder()
                .alt(mainResponseDto.getAlt())
                .badges(badges)
                .deliveries(deliveries)
                .delivery_fee(eachDetailResponseDto.getData().getDelivery_fee())
                .delivery_info(eachDetailResponseDto.getData().getDelivery_info())
                .description(mainResponseDto.getDescription())
                .detailSections(detailSections)
                .image(mainResponseDto.getImage())
                .n_price(mainResponseDto.getN_price())
                .s_price(mainResponseDto.getS_price())
                .point(eachDetailResponseDto.getData().getPoint())
                .thumbImages(thumbImages)
                .title(mainResponseDto.getTitle())
                .top_image(eachDetailResponseDto.getData().getTop_image())
                .build();

        amenu.getItems().add(item);

        return menuRepository.save(amenu);
    }


    public List<MainResponseDto> returnMenuItems(String menuName) {
        Map<String, String> map = new HashMap<>();
        map.put("main", "든든한 반찬");
        map.put("soup", "국");
        map.put("side", "밑반찬");

        Menu menu = menuRepository.findByName(map.get(menuName)).orElseThrow(() ->
                new IllegalArgumentException("해당 메뉴는 없습니다. menuName : " + menuName));
        List<Item> items = menu.getItems();
        List<MainResponseDto> result = new ArrayList<>();
        items.stream().forEach(item -> {
            List<Delivery> deliveries = new ArrayList<>();
            List<Badge> badges = new ArrayList<>();

            if (item.getDeliveries() != null) deliveries = item.getDeliveries();
            if (item.getBadges() != null) badges = item.getBadges();

            List<String> deliveryType = new ArrayList<>();
            List<String> badgeName = new ArrayList<>();
            deliveries.stream().forEach(delivery -> {
                deliveryType.add(delivery.getType());
            });
            badges.stream().forEach(badge -> {
                badgeName.add(badge.getName());
            });
            MainResponseDto mainResponseDto = new MainResponseDto(
                    item.getId().toString(), item.getImage(), item.getAlt(), deliveryType, item.getTitle(),
                    item.getDescription(), item.getN_price(), item.getS_price(), badgeName
            );
            result.add(mainResponseDto);
        });
        return result;
    }
}
