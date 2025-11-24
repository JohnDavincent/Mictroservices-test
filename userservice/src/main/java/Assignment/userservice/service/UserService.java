package Assignment.userservice.service;
import Assignment.userservice.entity.User;
import Assignment.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user){
        //random the password
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);

    }

    //return user Data
    public User getUserById(Long id){
        return userRepository.findById(id).orElse(null);

    }

    public User updateUser(Long id, User userDetails){
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        if(userDetails.getEmail() != null && !userDetails.getEmail().isEmpty()){
            user.setEmail(userDetails.getEmail());

        }
        if(userDetails.getPhone() != null && !userDetails.getPhone().isEmpty()){
            user.setPhone(userDetails.getPhone());
        }

        if (userDetails.getName() != null) {
            user.setName(userDetails.getName());
        }

        if (userDetails.getLocation() != null) {
            user.setLocation(userDetails.getLocation());
        }

        if (userDetails.getAge() != null) {
            user.setAge(userDetails.getAge());
        }
        return userRepository.save(user);
    }

}
