package com.sidedish4.codesquad.sidedish.web.controller;

import com.sidedish4.codesquad.sidedish.domain.Badge;
import com.sidedish4.codesquad.sidedish.domain.Delivery;
import com.sidedish4.codesquad.sidedish.domain.Item;
import com.sidedish4.codesquad.sidedish.domain.Menu;
import com.sidedish4.codesquad.sidedish.service.SideDishService;
import com.sidedish4.codesquad.sidedish.web.dto.AllItemResponseDto;
import com.sidedish4.codesquad.sidedish.web.dto.ItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
public class SidedishApiController {

    private final SideDishService sideDishService;

    private Logger logger = LoggerFactory.getLogger(SidedishApiController.class);

    @GetMapping("init")
    public String main() {
        String menuName = "든든한 반찬";
        String menu = "main";
        List<String> mainHashes = Arrays.asList("HBDEF", "HDF73", "HF778", "HFB53", "H077F", "H4665", "H1AA9", "HEDFB");
        for (String each : mainHashes) {
            sideDishService.saveItem(menu, each, menuName);
        }
        menuName = "국";
        menu = "soup";
        List<String> soupHashes = Arrays.asList("H72C3", "HA6EE", "H8CD0", "HE2E9", "HAA47", "H3254", "H26C7", "HFFF9");
        for (String each : soupHashes) {
            sideDishService.saveItem(menu, each, menuName);
        }
        menuName = "밑반찬";
        menu = "side";
        List<String> sideHashes = Arrays.asList("HBBCC", "H1939", "H8EA5", "H602F", "H9F0B", "H0FC6", "HCCFE", "HB9C1");
        for (String each : sideHashes) {
            sideDishService.saveItem(menu, each, menuName);
        }
        return "success";
    }

    @GetMapping("reverseProxy")
    public String reverseProxy() {
        return "reverseProxy";
    }

    @GetMapping("bootWar")
    public String bootWar() {
        return "bootWar";
    }

    @GetMapping("/{menuName}")
    public ResponseEntity<AllItemResponseDto> getAllItem(@PathVariable String menuName) {

        Map<String, Long> menuNames = new HashMap<String, Long>() {{
            put("main", 1L);
            put("soup", 2L);
            put("side", 3L);
        }};

        Menu savedMenu = sideDishService.findById(menuNames.get(menuName));
        logger.info("savedMenu : {}", savedMenu);
        List<ItemResponseDto> itemResponseDtos = new ArrayList<>();
        savedMenu.getItems().forEach(item -> itemResponseDtos.add(getItemResponseDto(item.getId(), savedMenu)));
        AllItemResponseDto allItemResponseDto = AllItemResponseDto.builder()
                .statusCode("200")
                .body(itemResponseDtos)
                .build();

        return new ResponseEntity<>(allItemResponseDto, HttpStatus.OK);
    }

    @GetMapping("/{menuName}/{id}")
    public ResponseEntity<ItemResponseDto> getAItem(@PathVariable String menuName,
                                                   @PathVariable Long id) {
        Map<String, Long> menuNames = new HashMap<String, Long>() {{
            put("main", 1L);
            put("soup", 2L);
            put("side", 3L);
        }};

        Menu savedMenu = sideDishService.findById(menuNames.get(menuName));
        ItemResponseDto itemResponseDto = getItemResponseDto(id, savedMenu);

        return new ResponseEntity<>(itemResponseDto, HttpStatus.OK);
    }

    private ItemResponseDto getItemResponseDto(@PathVariable Long id, Menu savedMenu) {
        Item savedItem = savedMenu.getItems().stream().filter(item -> item.getId().equals(id)).findFirst().orElseThrow(() ->
                new IllegalArgumentException("해당 아이템이 없습니다. id = " + id));

        return ItemResponseDto.builder()
                .detail_hash(savedItem.getId().toString())
                .alt(savedItem.getAlt())
                .description(savedItem.getDescription())
                .image(savedItem.getImage())
                .n_price(savedItem.getN_price())
                .s_price(savedItem.getS_price())
                .title(savedItem.getTitle())
                .badge(savedItem.getBadges().stream().map(Badge::getName).collect(Collectors.toList()))
                .delivery_type(savedItem.getDeliveries().stream().map(Delivery::getType).collect(Collectors.toList()))
                .build();
    }


}
