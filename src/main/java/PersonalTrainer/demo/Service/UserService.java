package PersonalTrainer.demo.Service;
import PersonalTrainer.demo.Entity.UserEntity;
import PersonalTrainer.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<?> registerUser(UserEntity user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("User already exists with this email.");
        }

        String password = user.getPassword();
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&#^()_+=<>\\[\\]{}|:;,./~-]).{8,}$";

        if (!Pattern.matches(pattern, password)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Password must include uppercase, lowercase, number, special character and be at least 8 characters long.");
        }

        UserEntity savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    public ResponseEntity<?> loginUser(String email, String password) {
        Optional<UserEntity> user = userRepository.findByEmailAndPassword(email, password);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid credentials");
        }
    }
}
