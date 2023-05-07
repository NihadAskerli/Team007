package com.example.team007.service;



import com.example.team007.config.UserPrinciple;
import com.example.team007.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserService userService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user=userService.findByEmail(email).orElseThrow();
        List<GrantedAuthority> authorityList=new ArrayList<>();
        for (Role role:user.getRole()
             ) {
            authorityList.add(new SimpleGrantedAuthority(role.name()));
        }

        return UserPrinciple
                .builder()
                .userId(user.getId())
                .email(user.getEmail())
                .authorities(authorityList)
                .password(user.getPassword())
                .build();
    }
}
