package com.controlSystem.security;

import com.controlSystem.domain.User;
import com.controlSystem.domain.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.beans.Encoder;
import java.util.ArrayList;
import java.util.List;

@Service("UserDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    BCryptPasswordEncoder encoder;

    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException
    {
        User user = new User("kostya.by@gmail.com", encoder.encode("password"), Role.ROLE_ADMIN, "Kostya", "Sokol");
        List<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
        auths.add(new SimpleGrantedAuthority(user.getRole().name()));
        String password = user.getPassword();
        return new ExtendedUser(login, password, true, true, true,
                true, auths, user.getId(), user.getFirstName(), user.getLastName());
    }
}
