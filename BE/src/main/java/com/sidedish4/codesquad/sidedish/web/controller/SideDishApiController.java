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
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    DeliveryRepository deliveryRepository;
    @Autowired
    BadgeRepository badgeRepository;


    @GetMapping("")
    public void testApi() {
        WebClient client = WebClient.create("https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/");
        String response = client.get().uri("main").retrieve().bodyToMono(String.class).block();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = new HashMap<>();
        List<?> itemsRow = new ArrayList<>();
        try {
            map = mapper.readValue(response, new TypeReference<Map<String, Object>>() {
            });
            itemsRow = (ArrayList) map.get("body");
        } catch (JsonProcessingException e) {
            System.out.println("에러로 들어옴");
        }
        for (int i = 0; i < itemsRow.size(); i++) {
            Menu menu = menuRepository.findById(1L).get();
            Map<String, Object> tempMap = (HashMap) itemsRow.get(i);
            Item item = new Item();
            item.setDetailHash(tempMap.get("detail_hash").toString());
            item.setImageUrl(tempMap.get("image").toString());
            item.setAlt(tempMap.get("alt").toString());
            item.setTitle(tempMap.get("title").toString());
            item.setDescription(tempMap.get("description").toString());
            item.setsPrice(tempMap.get("s_price").toString());
            if (tempMap.containsKey("n_price")){
                String nPrice = tempMap.get("n_price").toString();
            }

            System.out.println("-------------------------------------------1");
            if (tempMap.containsKey("badge")){
                ArrayList<String> badgeNames = (ArrayList<String>) tempMap.get("badge");
                for (int j = 0; j < badgeNames.size(); j++) {
                    if (!badgeRepository.existsByBadgeName(badgeNames.get(i))) {
                        badgeRepository.save(new Badge(badgeNames.get(i)));
                    }
                    item.addBadge(badgeRepository.findBadgeByBadgeName(badgeNames.get(i)).get());
                }
            }
            System.out.println("-------------------------------------------2");
            ArrayList<String> deliveryTypes = (ArrayList<String>) tempMap.get("delivery_type");
            for (int j = 0; j < deliveryTypes.size(); j++) {
                if (!deliveryRepository.existsByDeliveryType(deliveryTypes.get(i))) {
                    deliveryRepository.save(new Delivery(deliveryTypes.get(i)));
                }
                item.addDelivery(deliveryRepository.findDeliveryByDeliveryType(deliveryTypes.get(i)).get());
            }
            List<Item> menuItmes = menu.getItems();
            System.out.println(menuItmes.toString());
            menuItmes.add(item);
            menu.setItems(menuItmes);
            menuRepository.save(menu);
        }

//            if (itemData.size() == 7) {
//                Item item = new Item(detailHash, imageUrl, alt, title, description, sPrice);
//                for (int j = 0; j < deliveryTypes.size(); j++) {
//                    if (!deliveryRepository.existsByDeliveryType(deliveryTypes.get(i))) {
//                        deliveryRepository.save(new Delivery(deliveryTypes.get(i)));
//                    }
//                    item.addDelivery(deliveryRepository.findDeliveryByDeliveryType(deliveryTypes.get(i)).get());
//                }
//                menu.getItems().add(item);
//            }
//            if (itemData.size() == 9) {
//                String nPrice = tempMap.get("n_price").toString();
//                ArrayList<String> badgeNames = (ArrayList<String>) tempMap.get("badge");
//                Item item = new Item(detailHash, imageUrl, alt, title, description, nPrice, sPrice);
//                for (int j = 0; j < deliveryTypes.size(); j++) {
//                    if (!deliveryRepository.existsByDeliveryType(deliveryTypes.get(i))) {
//                        deliveryRepository.save(new Delivery(deliveryTypes.get(i)));
//                    }
//                    item.addDelivery(deliveryRepository.findDeliveryByDeliveryType(deliveryTypes.get(i)).get());
//                }
//                System.out.println("여기까지 -----------------------------2-3");
//                for (int j = 0; j < badgeNames.size(); j++) {
//                    System.out.println(badgeRepository.existsByBadgeName(badgeNames.get(i)));
//                    if (!badgeRepository.existsByBadgeName(badgeNames.get(i))) {
//                        badgeRepository.save(new Badge(badgeNames.get(i)));
//                    }
//                    item.addBadge(badgeRepository.findBadgeByBadgeName(badgeNames.get(i)).get());
//                }
//                System.out.println("여기까지 -----------------------------2-4");
//                menu.getItems().add(item);
//            }
//            System.out.println("여기까지 -----------------------------3");
//            menuRepository.save(menu);
//        }
    }
}
