package com.soft.eng.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.ott.OneTimeToken;
import org.springframework.security.web.authentication.ott.OneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.authentication.ott.RedirectOneTimeTokenGenerationSuccessHandler;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;

@Component
public class MagicLinkGenerator implements OneTimeTokenGenerationSuccessHandler {

    private OneTimeTokenGenerationSuccessHandler successHandler = new RedirectOneTimeTokenGenerationSuccessHandler("ott/sent");

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, OneTimeToken oneTimeToken) throws IOException, ServletException {
        String tokenValue = oneTimeToken.getTokenValue();

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(UrlUtils.buildRequestUrl(request));
        uriBuilder.replacePath(request.getContextPath());
        uriBuilder.path("/login/ott");
        uriBuilder.queryParam("token", tokenValue);

        System.out.println("Magic Link: " + uriBuilder.toUriString());

        successHandler.handle(request, response, oneTimeToken);
    }
}
