package jsp.supplychainmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jsp.supplychainmanagement.entity.Users;
import jsp.supplychainmanagement.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping("/register")
    public String register(@RequestBody Users user) {

        user.setPassword(encoder.encode(user.getPassword()));
        userRepo.save(user);

        return "User Registered Successfully";
    }
}