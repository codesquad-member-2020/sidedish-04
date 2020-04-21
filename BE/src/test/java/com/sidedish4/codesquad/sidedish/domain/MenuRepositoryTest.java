package com.sidedish4.codesquad.sidedish.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

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
}
