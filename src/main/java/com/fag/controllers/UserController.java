package com.fag.controllers;

import com.fag.domain.dtos.UserDTO;
import com.fag.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        UserDTO newUser = this.userService.createUser(user);

        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> listUsers() {
        return ResponseEntity.ok(this.userService.listAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(this.userService.findUserById(id));
    }

    @GetMapping("/document/{document}")
    public ResponseEntity<UserDTO> getUserByDocument(@PathVariable String document) {
        return ResponseEntity.ok(this.userService.findUserByDocument(document));
    }

}
