package com.sidedish4.codesquad.sidedish.service;

import com.sidedish4.codesquad.sidedish.web.dto.AccessTokenRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class AuthorizationService {

    private final RestTemplate restTemplate;


    public AccessTokenRequestDto getAccessToken(String client_id, String client_secret, String code, String redirect_url) {
        return AccessTokenRequestDto.builder()
                .client_id(client_id)
                .client_secret(client_secret)
                .code(code)
                .redirect_url(redirect_url)
                .build();
    }
}
