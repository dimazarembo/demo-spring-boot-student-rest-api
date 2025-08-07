package com.example.demo.repository;


import com.example.demo.repository.security.Role;
import com.example.demo.repository.security.RoleRepository;
import com.example.demo.repository.security.UserEntity;
import com.example.demo.repository.security.UserEntityRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitTestData implements CommandLineRunner {

    private UserEntityRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    public InitTestData(UserEntityRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if(userRepository.count()==0){
            Role adminRole = new Role();
            adminRole.setName("ROLE_ADMIN");
            roleRepository.save(adminRole);

            UserEntity admin = new UserEntity();
            admin.setUserName("admin");
            admin.getRoles().add(adminRole);
            admin.setPassword(passwordEncoder.encode("admin"));
            admin.setEmail("admin@demo.com");

            userRepository.save(admin);


            Role userRole = new Role();
            userRole.setName("ROLE_USER");
            roleRepository.save(userRole);

            UserEntity user = new UserEntity();
            user.setUserName("user");
            user.getRoles().add(userRole);
            user.setPassword(passwordEncoder.encode("user"));
            user.setEmail("user@demo.com");

            userRepository.save(user);
        }
    }
}
