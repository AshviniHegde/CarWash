package com.company.test.CarWash.controllers;


import com.company.test.CarWash.entity.Credentials;
import com.company.test.CarWash.enums.UserType;
import com.company.test.CarWash.repository.CredentialsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {
    @Autowired
    private CredentialsRepo credentialsRepo;

    @GetMapping("/login")
    public ResponseEntity<UserType> login(@Param("userId") Integer userId, @Param("password") String pass){
        Optional<Credentials> databaseObj = credentialsRepo.findById(userId);
        if(databaseObj.get().getPassword().compareTo(pass) == 0){
            return new ResponseEntity<>(databaseObj.get().getUserType(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @GetMapping("/signup")
    public boolean signup(Integer userId, String pass){
        credentialsRepo.save(Credentials.builder()
                .user_id(userId)
                .password(pass)
                .userType(UserType.USER)
                .build());
        return true;
    }
}
