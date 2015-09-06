package com.controlSystem.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class ExtendedUser extends User {
    private final long userId;

    private final String firstName;

    private final String lastName;

    public ExtendedUser(String username, String password, boolean enabled, boolean accountNonExpired,
                        boolean credentialsNonExpired,
                        boolean accountNonLocked,
                        Collection<? extends GrantedAuthority> authorities, long userId, String firstName, String lastName)
    {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
