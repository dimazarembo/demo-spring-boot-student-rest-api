package com.example.demo.controller.security;


import com.example.demo.repository.security.RegistrationRequestDTO;
import com.example.demo.repository.security.UserEntity;
import com.example.demo.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/security/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<UserEntity> registration(@RequestBody RegistrationRequestDTO regRequest) {
        if (regRequest.getUsername() != null && regRequest.getPassword() != null) {
            return ResponseEntity.ok(registrationService.register(regRequest.getUsername(), regRequest.getPassword()));
        }
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username or password cannot be null");

    }
}
