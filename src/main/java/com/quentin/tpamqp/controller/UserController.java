package com.quentin.tpamqp.controller;

import com.quentin.tpamqp.model.User;
import com.quentin.tpamqp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        userService.registerUser(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/validation")
    public ResponseEntity<String> validateUser(@RequestParam String token) {
        String responseMessage = "Compte validé. Token: " + token;
        return ResponseEntity.ok(responseMessage);
    }
}
