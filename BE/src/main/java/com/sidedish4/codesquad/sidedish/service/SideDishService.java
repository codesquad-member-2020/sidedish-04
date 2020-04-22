package com.sidedish4.codesquad.sidedish.service;

import com.sidedish4.codesquad.sidedish.domain.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@Service
@RequiredArgsConstructor
public class SideDishService {

    private final MenuRepository menuRepository;





}
