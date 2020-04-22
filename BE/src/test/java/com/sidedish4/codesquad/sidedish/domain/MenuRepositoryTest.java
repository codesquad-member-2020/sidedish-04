package com.sidedish4.codesquad.sidedish.domain;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuRepositoryTest {

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    private MenuRepository menuRepository;

    private Logger logger = LoggerFactory.getLogger(MenuRepositoryTest.class);

    @After
    public void tearDown() {
        menuRepository.deleteAll();
    }

    @Test
    public void contextLoad() {
        assertThat(ctx).isNotNull();
        logger.info("ctx is not null");
    }

    @Test
    public void loggerLoad() {
        assertThat(logger).isNotNull();
        logger.info("logger is not null");
    }

    @Test
    public void getMenu() {
        Menu menu = menuRepository.findById(1L).orElseThrow(() ->
                new IllegalArgumentException("해당 menu가 없습니다. "));
        assertThat(menu).isNotNull();
        logger.info("menu : {}", menu.toString());
    }


    @Test
    public void saveMenu() {
        // thumb_image와 detail_section 객체를 만든다.
        List<ThumbImage> thumbImages = new ArrayList<>();
        List<DetailSection> detailSections = new ArrayList<>();
        for (int count = 1; count < 3; count++) {
            thumbImages.add(ThumbImage.builder()
                    .url("thumb_image" + count)
                    .build());
        }
        for (int count = 1; count < 3; count++) {
            detailSections.add(DetailSection.builder()
                    .url("detail_section" + count)
                    .build());
        }

        // delivery, badge 객체를 만든다.
        List<Badge> badges = Arrays.asList(new Badge("할인특가"), new Badge("이벤트특가"));
        List<Delivery> deliveries = Arrays.asList(new Delivery("새벽배송"), new Delivery("전국배송"));

        // item 객체를 만든다. 그 후 List에 넣는다.
        Item AItem = Item.builder()
                .badges(badges)
                .deliveries(deliveries)
                .alt("alt")
                .description("description")
                .title("title")
                .s_price("1000원")
                .n_price("500원")
                .image("image")
                .delivery_fee("delivery_fee")
                .delivery_info("delivery_info")
                .point("point")
                .detailSections(detailSections)
                .thumbImages(thumbImages)
                .top_image("top_image")
                .build();

        //menu 객체를 찾는다.
        Menu menu = menuRepository.findById(1L).orElseThrow(() ->
                new IllegalArgumentException("해당 menu가 없습니다."));

        menu.add(AItem);

        Menu each = menuRepository.save(menu);
        assertThat(each.getId()).isEqualTo(1L);
        logger.info("menu : {}", each);
    }

}
