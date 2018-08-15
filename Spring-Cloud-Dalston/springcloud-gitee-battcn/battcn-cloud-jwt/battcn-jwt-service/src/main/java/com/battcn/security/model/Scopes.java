package com.battcn.security.model;

/**
 * Scopes
 *
 * @author Levin
 *         <p>
 *         2017-05-25
 */
public enum Scopes {
    REFRESH_TOKEN;

    public String authority() {
        return "ROLE_" + this.name();
    }
}
