package com.example.studycenter.web.resource;

import com.example.studycenter.domin.Users;
import com.example.studycenter.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<Users> creat(@RequestBody Users user){
        if (!checkPasswordLength(user.getPassword())){
            return new ResponseEntity("the password is too short", HttpStatus.BAD_REQUEST);
        }
        if (userService.checkUserName(user.getUserName())){
            return new ResponseEntity("This user is already registered", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.create(user));

    }
    private boolean checkPasswordLength(String password){
        return password.length()>=4;
    }

}