package com.sidedish4.codesquad.sidedish.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AuthorizationResponseDto {
    private String status;

    public AuthorizationResponseDto(String status) {
        this.status = status;
    }
}
