package com.sidedish4.codesquad.sidedish.domain.entity;

import org.springframework.data.annotation.Id;

public class Badge {
    @Id
    private Long id;
    private String badgeName;
}
