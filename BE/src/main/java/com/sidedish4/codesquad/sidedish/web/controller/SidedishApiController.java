package com.sidedish4.codesquad.sidedish.web.controller;

import com.sidedish4.codesquad.sidedish.domain.Menu;
import com.sidedish4.codesquad.sidedish.service.SideDishService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

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
}
