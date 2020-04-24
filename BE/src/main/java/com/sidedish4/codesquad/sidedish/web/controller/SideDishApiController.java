package com.sidedish4.codesquad.sidedish.web.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sidedish4.codesquad.sidedish.domain.dao.*;
import com.sidedish4.codesquad.sidedish.domain.entity.Badge;
import com.sidedish4.codesquad.sidedish.domain.entity.Delivery;
import com.sidedish4.codesquad.sidedish.domain.entity.Item;
import com.sidedish4.codesquad.sidedish.domain.entity.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.*;

@RestController
public class SideDishApiController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("")
    public void testApi() {
        WebClient client = WebClient.create("https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/");
        String response = client.get().uri("main").retrieve().bodyToMono(String.class).block();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        List<?> menuData = new ArrayList<>();
        try {
            map = mapper.readValue(response, new TypeReference<Map<String, Object>>() {});
            menuData = (ArrayList) map.get("body");
        } catch (JsonProcessingException e) {
            System.out.println("에러로 들어옴");
        }
        for (int i = 0; i < menuData.size(); i++) {
            Map<String, Object> tempMap = (HashMap) menuData.get(i);
            System.out.println(tempMap.keySet());
            Item item = new Item();
            if (tempMap.containsKey("n_price")){
                item.setnPrice(tempMap.get("n_price").toString());
            }
            item.setDetailHash(tempMap.get("detail_hash").toString());
            item.setImageUrl(tempMap.get("image").toString());
            item.setAlt(tempMap.get("alt").toString());
            item.setTitle(tempMap.get("title").toString());
            item.setDescription(tempMap.get("description").toString());
            item.setsPrice(tempMap.get("s_price").toString());

            ArrayList<String> deliveryTypes = (ArrayList<String>) tempMap.get("delivery_type");
            deliveryTypes.stream().forEach( delivery -> {
                if(!menuRepository.existsDeliveryByDeliveryType(delivery)){
                    menuRepository.createDelivery(delivery);
                }
                item.addDelivery(menuRepository.findDeliveryByDeliveryType(delivery).get());
                System.out.println(item.getDeliveries());
            });

            if (tempMap.containsKey("badge")){
                ArrayList<String> badges = (ArrayList<String>) tempMap.get("badge");
                badges.stream().forEach(badge -> {
                    if (!menuRepository.existsBadgeByBadgeId(badge)){
                         menuRepository.createBadge(badge);
                    }
                    item.addBadge(menuRepository.findBadgeByBadgeName(badge).get());
                    item.getBadges();
                });
            }

            Menu menu = menuRepository.findById(1L).get();
            menu.getItems().add(item);
//            menuRepository.save(menu);
        }
    }
}
