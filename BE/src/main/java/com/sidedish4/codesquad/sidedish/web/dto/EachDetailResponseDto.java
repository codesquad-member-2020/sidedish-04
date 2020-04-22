package com.sidedish4.codesquad.sidedish.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class EachDetailResponseDto {

    private String hash;
    private DetailResponseDto data;

}
