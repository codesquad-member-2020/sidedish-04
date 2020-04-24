package com.sidedish4.codesquad.sidedish.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class EachDetailResponseDto {

    private String hash;
    private DetailResponseDto data;

    @Builder
    public EachDetailResponseDto(String hash, DetailResponseDto data) {
        this.hash = hash;
        this.data = data;
    }
}
