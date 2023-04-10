package com.privatter.api.user.etc;

public enum UserSignUpResult {
    INVALID_SIGN_UP_METHOD,
    INVALID_METHOD,
    USER_EXISTS,
    UNVERIFIED_ACCOUNT,
    CAPTCHA_REQUIRED,
    UNKNOWN,

    OK(true);

    public final boolean isOk;

    UserSignUpResult(boolean isOk) {
        this.isOk = isOk;
    }

    UserSignUpResult() {
        this.isOk = false;
    }
}
