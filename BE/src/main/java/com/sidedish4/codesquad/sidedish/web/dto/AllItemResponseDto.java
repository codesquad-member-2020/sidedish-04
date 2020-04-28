package com.sidedish4.codesquad.sidedish.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class AllItemResponseDto {
    private String statusCode;
    private List<ItemResponseDto> body;

    @Builder
    public AllItemResponseDto(String statusCode, List<ItemResponseDto> body) {
        this.statusCode = statusCode;
        this.body = body;
    }
}
