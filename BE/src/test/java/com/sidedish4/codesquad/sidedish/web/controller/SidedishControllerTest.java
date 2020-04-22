package com.sidedish4.codesquad.sidedish.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.sidedish4.codesquad.sidedish.domain.MenuRepository;
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

    @After
    public void tearDown() throws Exception {
        menuRepository.deleteAll();
    }

    @Test
    public void getMainOfMockApi() throws JsonProcessingException {

        String url = "https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/main/HBDEF";

        //when
        String main = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        MainResponseDto mainResponseDto = gson.fromJson(main, MainResponseDto.class);
        assertThat(mainResponseDto).isNotNull();
        logger.info("mainResponseDto : {}", mainResponseDto);
    }

    @Test
    public void getAllMainOfMockApi() throws JsonProcessingException {

        String url = "https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/main";

        //when
        String main = restTemplate.getForObject(url, String.class);
        Gson gson = new Gson();
        AllMainResponseDto allMainResponseDto = gson.fromJson(main, AllMainResponseDto.class);
        assertThat(allMainResponseDto).isNotNull();
        logger.info("allmainResponseDto : {}", allMainResponseDto);
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
