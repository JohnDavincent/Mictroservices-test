package Assignment.authservice.controller;

import java.util.Collections;
import java.util.Map;
import Assignment.authservice.entity.User;
import Assignment.authservice.service.AuthService;
import Assignment.authservice.config.JwtUtil;
import Assignment.authservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




//make the controller to handle API
@RestController
@RequestMapping("/auth")
public class AuthController {

    //Register Endpoint
    @Autowired
    private AuthService authService;

    //for generate token
    @Autowired
    private JwtUtil jwtUtil;

    //to check if match the password
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User loginRequest) {
        User user = authService.loadUserByUsername(loginRequest.getUsername());

        if (passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            String token = jwtUtil.generateToken(user.getUsername());
            return Collections.singletonMap("token", token);
        } else {
            throw new RuntimeException("Wrong Password!, please try again");
        }
    }

}
