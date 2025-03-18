package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.models.UserModel;
import org.example.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers(){
        List<UserModel> result = userService.findAllUsers();
        return ResponseEntity.ok(result);
    }

    @PostMapping("/save-user")
    public ResponseEntity<?> saveUser(@RequestBody UserModel userModel){
        UserModel result = userService.createNewUser(userModel);
        return ResponseEntity.ok(result);
    }
}
