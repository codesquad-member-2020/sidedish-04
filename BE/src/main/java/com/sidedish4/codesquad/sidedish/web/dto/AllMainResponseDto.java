package com.sidedish4.codesquad.sidedish.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@ToString
public class AllMainResponseDto {

    private String statusCode;
    private List<MainResponseDto> body;
}
