package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;
import com.example.demo.services.UserServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{userId}")
    public ResponseEntity<?> getById(@PathVariable String userId){
        try {
            User ans = userService.getById(userId);
            return new ResponseEntity<>(ans, HttpStatus.OK);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user){
        try {
            User ans = userService.create(user);
            return new ResponseEntity<>(ans, HttpStatus.CREATED);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user){
        try {
            User ans = userService.update(user);
            return new ResponseEntity<>(ans, HttpStatus.OK);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<?> remove(@PathVariable String userId){
        try {
            userService.remove(userId);
            return new ResponseEntity<>("", HttpStatus.OK);
        } catch (UserServiceException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
