package com.privatter.api.verification.captcha;

public class CaptchaVerificationResultModel {
    private boolean success;

    public CaptchaVerificationResultModel(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
