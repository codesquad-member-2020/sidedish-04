package com.sidedish4.codesquad.sidedish.web.controller;

import com.sidedish4.codesquad.sidedish.service.SideDishService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SidedishApiController {

    private final SideDishService sideDishService;

    @GetMapping("hello")
    public String hello() {
        return "hello";
    }
}
