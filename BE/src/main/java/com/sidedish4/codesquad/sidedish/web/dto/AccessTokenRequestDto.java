package com.sidedish4.codesquad.sidedish.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AccessTokenRequestDto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_url;

    @Builder
    public AccessTokenRequestDto(String client_id, String client_secret, String code, String redirect_url) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.code = code;
        this.redirect_url = redirect_url;
    }
}
