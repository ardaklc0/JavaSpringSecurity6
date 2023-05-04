package com.ardaklc.SpringSecuritySix.auth;

import com.ardaklc.SpringSecuritySix.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomUserDetail implements UserDetails {

    private final String user_name;
    private final String user_password;
    private final List<GrantedAuthority> user_roles;

    public CustomUserDetail(User user) {
        this.user_name = user.getUser_name();
        this.user_password = user.getUser_password();
        this.user_roles = user.getUser_roles().stream().map((roles -> new SimpleGrantedAuthority(roles.getUser_role_name()))).collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user_roles;
    }

    @Override
    public String getPassword() {
        return user_password;
    }

    @Override
    public String getUsername() {
        return user_name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
