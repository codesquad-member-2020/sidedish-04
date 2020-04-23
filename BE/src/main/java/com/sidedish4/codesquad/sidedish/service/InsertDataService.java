package com.sidedish4.codesquad.sidedish.service;

import com.sidedish4.codesquad.sidedish.domain.dao.MenuRepository;

public class InsertDataService {

    private MenuRepository menuRepository;

    public InsertDataService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

}
