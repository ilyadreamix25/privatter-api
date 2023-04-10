package com.privatter.api.verification.token;

public enum TokenVerificationResult {
    NOT_FOUND,
    INVALID_HASH,
    ACTIVATED,
    EXPIRED,
    ERROR,

    OK(true);

    public final boolean valid;

    TokenVerificationResult(boolean valid) {
        this.valid = valid;
    }

    TokenVerificationResult() {
        this.valid = false;
    }
}
