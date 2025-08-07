package com.example.demo.service;

import com.example.demo.repository.security.Role;
import com.example.demo.repository.security.RoleRepository;
import com.example.demo.repository.security.UserEntity;
import com.example.demo.repository.security.UserEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class RegistrationService {

    private final PasswordEncoder passwordEncoder;
    private final UserEntityRepository userRepository;
    private final RoleRepository roleRepository;

    public RegistrationService(PasswordEncoder passwordEncoder, UserEntityRepository userRepository, RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public UserEntity register(String username, String password) {
        if(userRepository.findByUserName(username).isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }
        UserEntity user = new UserEntity();
        user.setUserName(username);
        user.setPassword(passwordEncoder.encode(password));
        Role userRole = roleRepository.findByName("ROLE_USER").
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Role can not be find in BD"));
        user.getRoles().add(userRole);
        userRepository.save(user);
        return user;


    }
}
