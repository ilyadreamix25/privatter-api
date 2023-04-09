package com.privatter.api.user.jpa;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Embedded
    private UserAuth auth;

    @Embedded
    private UserProfile profile;

    @Embedded
    private UserMetadata metadata;

    @Column(name = "verified", nullable = false)
    private boolean verified;

    public User(String id, UserAuth auth, UserProfile profile, UserMetadata metadata, boolean verified) {
        this.id = id;
        this.auth = auth;
        this.profile = profile;
        this.metadata = metadata;
        this.verified = verified;
    }

    public User(UserAuth auth, UserProfile profile) {
        this.id = UUID.randomUUID().toString();
        this.auth = auth;
        this.profile = profile;
        this.metadata = new UserMetadata();
        this.verified = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserAuth getAuth() {
        return auth;
    }

    public void setAuth(UserAuth auth) {
        this.auth = auth;
    }

    public UserProfile getProfile() {
        return profile;
    }

    public void setProfile(UserProfile profile) {
        this.profile = profile;
    }

    public UserMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(UserMetadata metadata) {
        this.metadata = metadata;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
