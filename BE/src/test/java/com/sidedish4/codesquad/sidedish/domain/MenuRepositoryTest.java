package com.sidedish4.codesquad.sidedish.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
    public void getDetail() {
        Menu menu = menuRepository.findById(1L).orElseThrow(() ->
                new IllegalArgumentException("해당 menu가 없습니다. "));
        Detail detail = new Detail();
        for (Item each : menu.getItems()) {
            if (each.getId().equals(1L)) {
               detail = each.getDetail();
            }
        }
        assertThat(detail).isNotNull();
        logger.info("detail : {}",detail);
    }
}
