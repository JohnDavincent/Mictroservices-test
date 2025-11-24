package Assignment.userservice.controller;

import Assignment.userservice.entity.User;
import Assignment.userservice.service.UserService;
import Assignment.userservice.config.JwtUtil;
import Assignment.userservice.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




//make the controller to handle API
@RestController
@RequestMapping("/users")
public class UserController {

    //Register Endpoint
    @Autowired
    private UserService userService;

    //for generate token
    @Autowired
    private JwtUtil jwtUtil;

    //for access database
    @Autowired
    private UserRepository userRepository;

    //to check if match the password
    @Autowired
    private PasswordEncoder passwordEncoder;


    //Endpoint login
    @PostMapping("/register")
    public User register (@RequestBody User user){
        return userService.registerUser(user);
    }

    // Endpoint to check user profile
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.updateUser(id, user);

    }

}
