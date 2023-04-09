package com.privatter.api.global;

public enum PrivatterStatusCode {
    OK(0, true),

    SERVER_ERROR(1000),
    INVALID_REQUEST(1001),
    SERVICE_DISABLED(1002),
    INVALID_CAPTCHA(1003),
    INVALID_VERIFICATION_TOKEN(1004),
    SERVICE_NOT_FOUND(1005),

    USER_EXISTS(2000),
    SENT_EMAIL(2001);

    public final int value;
    public final boolean isOk;

    PrivatterStatusCode(int value, boolean isOk) {
        this.value = value;
        this.isOk = isOk;
    }

    PrivatterStatusCode(int value) {
        this.value = value;
        this.isOk = false;
    }
}
