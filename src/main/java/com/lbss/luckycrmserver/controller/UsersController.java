package com.lbss.luckycrmserver.controller;

import com.lbss.luckycrmserver.model.UsersModel;
import com.lbss.luckycrmserver.security.services.UsersDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UsersDetailsImpl usersDetailsImpl;

    @GetMapping("/list")
    public Iterable<UsersModel> listAllUsers() {
        return usersDetailsImpl.listAllUsers();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listUserById(@PathVariable Long id) {
        return usersDetailsImpl.listUserById(id);
    }

    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(@RequestBody UsersModel usersModel, @PathVariable Long id) {
        return usersDetailsImpl.updateUser(usersModel, id);
    }

    @PostMapping("/add-user")
    public ResponseEntity<?> addNewUser(@RequestBody UsersModel usersModel) {
        return usersDetailsImpl.addUser(usersModel);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return usersDetailsImpl.deleteUser(id);
    }
}
