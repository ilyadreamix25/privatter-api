package com.privatter.api.user.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserMetadata {
    @Column(name = "metadata_signed_up_at", nullable = false)
    private long createdAt;

    @Column(name = "metadata_last_sign_in_at", nullable = false)
    private long lastSignInAt;

    public UserMetadata(long createdAt, long lastSignInAt) {
        this.createdAt = createdAt;
        this.lastSignInAt = lastSignInAt;
    }

    public UserMetadata() {
        this.createdAt = System.currentTimeMillis();
        this.lastSignInAt = 0;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getLastSignInAt() {
        return lastSignInAt;
    }

    public void setLastSignInAt(long lastSignInAt) {
        this.lastSignInAt = lastSignInAt;
    }
}
