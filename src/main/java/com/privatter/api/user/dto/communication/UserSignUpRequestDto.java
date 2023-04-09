package com.privatter.api.user.dto.communication;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserSignUpRequestDto {
    @NotEmpty(message = "Field \"authKey\" must not be empty")
    private String authKey;

    @NotEmpty(message = "Field \"authValue\" must not be empty")
    private String authValue;

    private String captchaToken;

    @NotEmpty(message = "Field \"authValue\" must not be empty")
    @Pattern(regexp = "\\A[A-Za-z\\d_]+\\z", message = "Field \"profileNickname\" is invalid")
    @Length(min = 4, max = 24, message = "Field \"profileNickname\" must be between 4 and 24 characters long")
    private String profileNickname;

    private String profileDescription;

    private String profileIconUrl;

    public String getAuthKey() {
        return authKey;
    }

    public void setAuthKey(String authKey) {
        this.authKey = authKey;
    }

    public String getAuthValue() {
        return authValue;
    }

    public void setAuthValue(String authValue) {
        this.authValue = authValue;
    }

    public String getCaptchaToken() {
        return captchaToken;
    }

    public void setCaptchaToken(String captchaToken) {
        this.captchaToken = captchaToken;
    }

    public String getProfileNickname() {
        return profileNickname;
    }

    public void setProfileNickname(String profileNickname) {
        this.profileNickname = profileNickname;
    }

    public String getProfileDescription() {
        return profileDescription;
    }

    public void setProfileDescription(String profileDescription) {
        this.profileDescription = profileDescription;
    }

    public String getProfileIconUrl() {
        return profileIconUrl;
    }

    public void setProfileIconUrl(String profileIconUrl) {
        this.profileIconUrl = profileIconUrl;
    }
}
