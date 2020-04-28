package com.sidedish4.codesquad.sidedish.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class DetailResponseDto {

    private String hash;
    private DetailDto data;

    @Builder
    public DetailResponseDto(String hash, DetailDto data) {
        this.hash = hash;
        this.data = data;
    }
}
