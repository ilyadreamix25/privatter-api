package com.privatter.api.user.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

public class UserSignUpBody {
    @NotNull
    private String authKey;

    @NotNull
    private String authValue;

    private String captchaToken;

    @NotNull
    @Pattern(regexp = "\\A[A-Za-z\\d_]+\\z")
    @Length(min = 4, max = 36)
    private String profileNickname;

    private String profileDescription;

    private String profileIconUrl;

    public UserSignUpBody(
        String authKey,
        String authValue,
        String captchaToken,
        String profileNickname,
        String profileDescription,
        String profileIconUrl
    ) {
        this.authKey = authKey;
        this.authValue = authValue;
        this.captchaToken = captchaToken;
        this.profileNickname = profileNickname;
        this.profileDescription = profileDescription;
        this.profileIconUrl = profileIconUrl;
    }

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
