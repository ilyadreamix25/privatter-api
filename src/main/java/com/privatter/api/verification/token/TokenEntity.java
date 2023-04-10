package com.privatter.api.verification.token;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "tokens")
public class TokenEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "action", nullable = false)
    private String action;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "created_at", nullable = false)
    private long createdAt;

    @Column(name = "expiresAt", nullable = false)
    private long expiresAt;

    @Column(name = "activated", nullable = false)
    private boolean activated;

    public TokenEntity(String id, String action, String userId, long createdAt, long expiresAt, boolean activated) {
        this.id = id;
        this.action = action;
        this.userId = userId;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
        this.activated = activated;
    }

    public TokenEntity(String action, long expiresAt) {
        this.id = UUID.randomUUID().toString();
        this.action = action;
        this.createdAt = System.currentTimeMillis();
        this.expiresAt = expiresAt;
        this.activated = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(long expiresAt) {
        this.expiresAt = expiresAt;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
