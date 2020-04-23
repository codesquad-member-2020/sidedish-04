//package com.sidedish4.codesquad.sidedish.web.parser;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.sidedish4.codesquad.sidedish.domain.dao.MenuRepository;
//import com.sidedish4.codesquad.sidedish.domain.entity.Item;
//import com.sidedish4.codesquad.sidedish.domain.entity.Menu;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import java.util.*;
//
//@Service
//public class SidedishParser {
//
//    @Autowired
//    MenuRepository menuRepository;
//
//
//    public static final String BASE_URL = "https://h3rb9c0ugl.execute-api.ap-northeast-2.amazonaws.com/develop/baminchan/";
//
//    public void getSideDish() {
//        WebClient client = WebClient.create(BASE_URL);
//         String response = client.get().uri("main").retrieve().bodyToMono(String.class).block();
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String,Object> map = new HashMap<>();
//        List<?> itemsRow = new ArrayList<>();
//        try{
//            map = mapper.readValue(response, new TypeReference<Map<String, Object>>() {});
//            itemsRow = (ArrayList) map.get("body");
//        } catch (JsonProcessingException e){
//            System.out.println("에러로 들어옴");
//        }
//        for (int i = 0; i < itemsRow.size(); i++) {
//            Item item;
//            Map<String,Object> tempMap = new HashMap<>();
//            tempMap = (HashMap)itemsRow.get(i);
//            Set<String> itemData = tempMap.keySet();
//            String detailHash = tempMap.get("detail_hash").toString();
//            String imageUrl = tempMap.get("image").toString();
//            String alt = tempMap.get("alt").toString();
//            ArrayList<String> deliveryTypes = (ArrayList<String>) tempMap.get("delivery_type");
//            String title = tempMap.get("title").toString();
//            String description = tempMap.get("description").toString();
//            String sPrice = tempMap.get("s_price").toString();
//
//            if (itemData.size() == 7){
//                item = new Item(detailHash,imageUrl,alt,deliveryTypes,title,description,sPrice);
//            }
//            if (itemData.size() == 9){
//                String nPrice = tempMap.get("n_price").toString();
//                ArrayList<String> badges = (ArrayList<String>) tempMap.get("badge");
//                item = new Item(detailHash,imageUrl,alt,deliveryTypes,title,description,nPrice,sPrice,badges);
//
//            }
//        }
//
//    }
//}
