package com.example.demo.service;

import com.example.demo.repository.security.Role;
import com.example.demo.repository.security.UserEntity;
import com.example.demo.repository.security.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private final UserEntityRepository userRepository;

    public CustomUserDetailsService(PasswordEncoder passwordEncoder, UserEntityRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));


        return User.withUsername(userEntity.getUserName()).password(userEntity.getPassword())
                .authorities(userEntity.getRoles().stream()
                        .map(Role::getName)
                        .toArray(String[]::new)).build();

    }
}
