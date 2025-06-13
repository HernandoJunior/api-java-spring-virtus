package com.virtusconsultoria.model;

import lombok.Getter;

@Getter
public enum ColaboradorRole {
    ADMIN("ADMIN"),
    USER("USER");

    private final String role;

    ColaboradorRole(String role){
        this.role = role;
    }
}
