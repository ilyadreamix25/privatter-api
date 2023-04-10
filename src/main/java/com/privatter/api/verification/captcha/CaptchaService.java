package com.privatter.api.verification.captcha;

import org.jetbrains.annotations.NotNull;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Pattern;

@Service
public class CaptchaService {
    @Autowired
    private CaptchaConfiguration configuration;

    public boolean verifyCaptchaToken(String token) {
        try {
            if (configuration.isDebug())
                return true;

            if (!isCaptchaValid(token))
                return false;

            var restTemplate = new RestTemplate();
            var response = restTemplate.getForEntity(
                configuration.getRemote(),
                CaptchaVerificationResultModel.class,
                configuration.getSecret(),
                token
            );

            if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null)
                return false;

            return response.getBody().isSuccess();
        } catch (Exception exception) {
            LoggerFactory
                .getLogger(CaptchaService.class)
                .error("Cannot verify token " + token, exception);
            return true;
        }
    }

    private boolean isCaptchaValid(@NotNull String token) {
        return !token.isBlank() && Pattern.matches("[A-Za-z0-9_-]+", token);
    }
}
