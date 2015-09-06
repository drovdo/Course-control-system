package com.controlSystem.model;

import com.controlSystem.security.ExtendedUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class UserModel {

    private String firstName;

    private String lastName;

    private String role;

    public UserModel() {
    }

    public UserModel(Authentication authentication) {
        ExtendedUser extendedUser = (ExtendedUser) authentication.getPrincipal();
        this.firstName = extendedUser.getFirstName();
        this.lastName = extendedUser.getLastName();

        for (GrantedAuthority grantedAuthority : extendedUser.getAuthorities()) {
            this.role = grantedAuthority.getAuthority();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
