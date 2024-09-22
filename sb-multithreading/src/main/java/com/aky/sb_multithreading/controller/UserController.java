package com.aky.sb_multithreading.controller;

import com.aky.sb_multithreading.entity.User;
import com.aky.sb_multithreading.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users", consumes={MediaType.MULTIPART_FORM_DATA_VALUE}, produces=("application/json"))
    public ResponseEntity SaveAllUsers(@RequestParam (value = "files") MultipartFile[] files) throws Exception {

        for(MultipartFile file : files){
            userService.SaveUsers(file);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/users",produces=("application/json"))
    public CompletableFuture<ResponseEntity> findAllUsers() throws Exception {
       return userService.findAllUsers().thenApply(ResponseEntity::ok);
    }

    @GetMapping(value = "/multicallusers",produces=("application/json"))
    public ResponseEntity getUsersByMultiCall() throws Exception {
        CompletableFuture<List<User>> users1 = userService.findAllUsers();
        CompletableFuture<List<User>> users2 = userService.findAllUsers();
        CompletableFuture<List<User>> users3 = userService.findAllUsers();

        CompletableFuture.allOf(users1,users2,users3).join();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
