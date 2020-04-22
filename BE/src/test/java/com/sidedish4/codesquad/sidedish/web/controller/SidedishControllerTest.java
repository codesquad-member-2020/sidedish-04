package com.sidedish4.codesquad.sidedish.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sidedish4.codesquad.sidedish.domain.*;
import com.sidedish4.codesquad.sidedish.web.dto.AllMainResponseDto;
import com.sidedish4.codesquad.sidedish.web.dto.DetailResponseDto;
import com.sidedish4.codesquad.sidedish.web.dto.EachDetailResponseDto;
import com.sidedish4.codesquad.sidedish.web.dto.MainResponseDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SidedishControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MenuRepository menuRepository;

    private Logger logger = LoggerFactory.getLogger(SidedishControllerTest.class);

//    @After
//    public void tearDown() throws Exception {
//        menuRepository.deleteAll();
//    }

    @Test
    public void saveMainOfMockApi() throws JsonProcessingException {

        String hash = "/HDF73";

        Menu savedMenu = saveEach(hash);

        assertThat(savedMenu.getItems().get(0).getId()).isGreaterThan(0L);

        logger.info("savedMenu : {}", savedMenu);
    }

    private Menu saveEach(String hash) {
        String menu = "main";
        String detail = "detail";
        String url = "https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/"+menu+hash;
        String detailUrl = "https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/"+detail+hash;

        //each
        String main = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        MainResponseDto mainResponseDto = gson.fromJson(main, MainResponseDto.class);

        String detailJson = restTemplate.getForObject(detailUrl, String.class);
        EachDetailResponseDto eachDetailResponseDto = gson.fromJson(detailJson, EachDetailResponseDto.class);

        String menuName = "든든한 반찬";

        Menu amenu = menuRepository.findByName(menuName).orElseThrow(() ->
                new IllegalArgumentException("해당 메뉴는 없습니다. menuName : "+menuName));

        List<Badge> badges = new ArrayList<>();
        if (mainResponseDto.getBadge() != null) mainResponseDto.getBadge().forEach(b -> badges.add(new Badge(b)));
        List<Delivery> deliveries = new ArrayList<>();
        mainResponseDto.getDelivery_type().forEach(d -> deliveries.add(new Delivery(d)));
        List<ThumbImage> thumbImages = new ArrayList<>();
        eachDetailResponseDto.getData().getThumb_images().forEach(t -> thumbImages.add(new ThumbImage(t)));
        List<DetailSection> detailSections = new ArrayList<>();
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

    @Test
    public void getAllMainOfMockApi() throws JsonProcessingException {

        String url = "https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/main";

        //when
        String main = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        AllMainResponseDto allMainResponseDto = gson.fromJson(main, AllMainResponseDto.class);
        assertThat(allMainResponseDto).isNotNull();
        logger.info("allMainResponseDto : {}", allMainResponseDto);
    }

    @Test
    public void getDetailOfMockApi() {
        String url = "https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/detail/HBDEF";

        //when
        String main = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        EachDetailResponseDto eachDetailResponseDto = gson.fromJson(main, EachDetailResponseDto.class);
        assertThat(eachDetailResponseDto).isNotNull();
        logger.info("eachDetailResponseDto : {}", eachDetailResponseDto);
//        logger.info("main : {}", main);
    }
}
