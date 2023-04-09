package com.privatter.api.user.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserAuth {
    @Column(name = "auth_key", nullable = false)
    private String key;

    @Column(name = "auth_value", nullable = false)
    private String value;

    public UserAuth(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
