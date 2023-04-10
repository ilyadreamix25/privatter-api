package com.privatter.api.user.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserMetadata {
    @Column(name = "metadata_signed_up_at", nullable = false)
    private long signedUpAt;

    @Column(name = "metadata_last_sign_in_at", nullable = false)
    private long lastSignInAt;

    public UserMetadata(long signedUpAt, long lastSignInAt) {
        this.signedUpAt = signedUpAt;
        this.lastSignInAt = lastSignInAt;
    }

    public UserMetadata() {
        this.signedUpAt = System.currentTimeMillis();
        this.lastSignInAt = 0;
    }

    public long getSignedUpAt() {
        return signedUpAt;
    }

    public void setSignedUpAt(long signedUpAt) {
        this.signedUpAt = signedUpAt;
    }

    public long getLastSignInAt() {
        return lastSignInAt;
    }

    public void setLastSignInAt(long lastSignInAt) {
        this.lastSignInAt = lastSignInAt;
    }
}
