package com.privatter.api.user.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserProfile {
    @Column(name = "profile_nickname", nullable = false)
    private String nickname;

    @Column(name = "profile_description")
    private String description;

    @Column(name = "profile_icon_url")
    private String iconUrl;

    public UserProfile(String nickname, String description, String iconUrl) {
        this.nickname = nickname;
        this.description = description;
        this.iconUrl = iconUrl;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}
