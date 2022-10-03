package com.lbss.luckycrmserver.controller;

import com.lbss.luckycrmserver.model.UsersModel;
import com.lbss.luckycrmserver.services.UsersServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UsersServices usersServices;

    @GetMapping("/list")
    public Iterable<UsersModel> listAllUsers() {
        return usersServices.listAllUsers();
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<?> listUserById(@PathVariable Long id) {
        return usersServices.listUserById(id);
    }

    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(@RequestBody UsersModel usersModel, @PathVariable Long id) {
        return usersServices.updateUser(usersModel, id);
    }

    @PostMapping("/add-user")
    public ResponseEntity<?> addNewUser(@RequestBody UsersModel usersModel) {
        return usersServices.addUser(usersModel);
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return usersServices.deleteUser(id);
    }
}
