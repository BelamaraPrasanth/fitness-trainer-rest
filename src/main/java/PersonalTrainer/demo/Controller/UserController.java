package PersonalTrainer.demo.Controller;

import PersonalTrainer.demo.Entity.UserEntity;
import PersonalTrainer.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
  @CrossOrigin(origins = "*")
    @RestController
    @RequestMapping("/api/users")
    public class UserController {

        @Autowired
        private UserService userService;

        @PostMapping("/register")
        public ResponseEntity<?> registerUser(@RequestBody UserEntity user) {
            return userService.registerUser(user);
        }

        @PostMapping("/login")
        public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginData) {
            String email = loginData.get("email");
            String password = loginData.get("password");
            return userService.loginUser(email, password);
        }
    }


