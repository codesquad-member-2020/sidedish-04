package com.sidedish4.codesquad.sidedish.web.controller;

import com.sidedish4.codesquad.sidedish.service.AuthorizationService;
import com.sidedish4.codesquad.sidedish.web.dto.AccessTokenRequestDto;
import com.sidedish4.codesquad.sidedish.web.dto.AuthorizationResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@Getter
@RequiredArgsConstructor
public class LoginApiController {

    private final Logger logger = LoggerFactory.getLogger(LoginApiController.class);
    private final AuthorizationService authorizationService;
    private final RestTemplate restTemplate;

    @GetMapping("/github/callback")
    public RedirectView authorize(@RequestParam("code") String code) {
        logger.info("code: {}", code);
        String url = "https://github.com/login/oauth/access_token";
        String client_id = "bc4a9e51a6494c1d0626";
        String client_secret = "18630d9ac18c119ed867f196c97a2c25d369f382";
        String redirect_url = "http://15.164.33.98/api/sidedish/github/callback";
        AccessTokenRequestDto accessTokenRequestDto =
                authorizationService.getAccessToken(client_id, client_secret, code, redirect_url);
        String mainUrl = "http://15.164.33.98/";
        String loginUrl = "http://15.164.33.98/login";
        try {
            String accessToken = restTemplate.postForObject(url, accessTokenRequestDto, String.class);
            logger.info("accessToken : {}", accessToken);
            return new RedirectView(mainUrl);
        } catch (Exception e) {
            return new RedirectView(loginUrl);
        }
    }
}
