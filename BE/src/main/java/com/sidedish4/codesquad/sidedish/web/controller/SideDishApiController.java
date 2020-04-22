package com.sidedish4.codesquad.sidedish.web.controller;

import com.sidedish4.codesquad.sidedish.domain.entity.Detail;
import com.sidedish4.codesquad.sidedish.domain.entity.Item;
import com.sidedish4.codesquad.sidedish.domain.entity.Menu;
import com.sidedish4.codesquad.sidedish.domain.dao.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SideDishApiController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("")
    public void testApi() {
        Item item = new Item();
        Detail detail = new Detail();
        detail.setDeliveryFee("2,500원 (40,000원 이상 구매 시 무료)");
        detail.setDeliveryInfo("서울 경기 새벽배송 / 전국택배 (제주 및 도서산간 불가) [화 · 수 · 목 · 금 · 토] 수령 가능한 상품입니다.");
        detail.setPoint("312원");
        detail.setProductDescription("경상도 명물 요리 세 가지를 한 상에!");
        item.setAlt("[윤식당] 불고기 with Rice (재료)");
        item.setTitle("[윤식당] 불고기 with Rice (재료)");
        item.setImageUrl("https://cdn.bmf.kr/_data/product/HF56E/2d3f99a9a35601f4e98837bc4d39b2c8.jpg");
        item.setnPrice("8,000원");
        item.setsPrice("7,000원");
        item.setDescription("윤식당 불고기메뉴의 가장 기본인 불고기라이스! (마더소스 포함)");
        item.setDetailHash("HBDEF");
        item.setDetail(detail);
        System.out.println("여기까지 : 1");
        Menu menu = menuRepository.findById(1L).orElse(null);
        System.out.println("여기까지 : 2");

        List<Item> items = menu.getItems();
        System.out.println("여기까지 : 3");
        items.add(item);
        System.out.println("여기까지 : 4");
        menu.setItems(items);
        System.out.println("여기까지 : 5");
        menuRepository.save(menu);
    }
}
