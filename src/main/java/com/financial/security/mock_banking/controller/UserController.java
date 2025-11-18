package com.financial.security.mock_banking.controller;

import com.financial.security.mock_banking.domain.User;
import com.financial.security.mock_banking.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
     this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> responseUser(@RequestBody User user) {
        try {
            User registerUser = userService.registerUser(user);

            return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("회원가입 중 서버 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
    }

}
