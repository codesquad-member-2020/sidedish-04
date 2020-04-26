package com.sidedish4.codesquad.sidedish.web.controller;

import com.sidedish4.codesquad.sidedish.service.SideDishService;
import com.sidedish4.codesquad.sidedish.web.dto.AllItemResponseDto;
import com.sidedish4.codesquad.sidedish.web.dto.ItemResponseDto;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SidedishApicontrollerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SideDishService sideDishService;

    private Logger logger = LoggerFactory.getLogger(SidedishApicontrollerTest.class);

    @Before
    public void setUp() throws Exception {
        String menu = "main";
        String[] hashes = {"HBDEF", "HDF73"};
        String menuName = "든든한 반찬";
        for (String hash : hashes) {
            sideDishService.saveItem(menu, hash, menuName);
        }
    }

    @Test // main 아이템 중 id = 1 인 아이템 리턴
    public void getAMain() {
        // given
        String menuName = "main";
        Long id = 1L;

        String url = "http://localhost:" + port + "/" + menuName + "/" + id;
        logger.info("url : {}", url);

        //when
        ResponseEntity<ItemResponseDto> responseEntity = restTemplate.getForEntity(url, ItemResponseDto.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getDetail_hash()).isEqualTo("1");
        logger.info("Amain : {}", responseEntity.getBody());
    }

    @Test
    public void getAllMain() {
        //given
        String menuName = "main";

        String url = "http://localhost:" + port + "/" + menuName;
        logger.info("url : {}" , url);

        //when
        ResponseEntity<AllItemResponseDto> responseEntity
                = restTemplate.getForEntity(url, AllItemResponseDto.class);

        //given
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody().getBody().size()).isEqualTo(2);
        logger.info("Allmain : {}", responseEntity.getBody());
    }
}
