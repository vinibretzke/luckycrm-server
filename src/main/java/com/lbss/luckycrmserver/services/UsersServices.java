package com.lbss.luckycrmserver.services;

import com.lbss.luckycrmserver.model.ResponseModel;
import com.lbss.luckycrmserver.model.UsersModel;
import com.lbss.luckycrmserver.repository.UsersRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsersServices {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private ResponseModel responseModel;

    //list all users
    public Iterable<UsersModel> listAllUsers() {
        return usersRepository.findAll();
    }

    // list user by id
    public ResponseEntity<?> listUserById(Long id) {
        if (usersRepository.findById(id).isPresent()) {
            return new ResponseEntity<>(usersRepository.findById(id), HttpStatus.OK);
        } else {
            responseModel.setMessage("User not found");
            return new ResponseEntity<>(responseModel, HttpStatus.NOT_FOUND);
        }
    }

    //add user
    public ResponseEntity<?> addUser(UsersModel usersModel) {
        if ( usersModel.getUsername() == null || usersModel.getUsername().isEmpty() ) {
            responseModel.setMessage("Username is required");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else if ( usersModel.getPassword() == null || usersModel.getPassword().isEmpty() ) {
            responseModel.setMessage("Password is required");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else if ( usersModel.getFullname() == null || usersModel.getFullname().isEmpty() ) {
            responseModel.setMessage("Fullname is required");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else if ( usersModel.getEmail() == null || usersModel.getEmail().isEmpty() ) {
            responseModel.setMessage("Email is required");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else if ( usersModel.getCpf() == null || usersModel.getCpf().isEmpty() ) {
            responseModel.setMessage("CPF is required");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else if ( usersModel.getDateOfBirth() == null || usersModel.getDateOfBirth().isEmpty() ) {
            responseModel.setMessage("Date of birth is required");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else {
            usersRepository.save(usersModel);
            responseModel.setMessage("User added successfully");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
        }
    }

    // update user
    public ResponseEntity<?> updateUser(UsersModel usersModel, Long id) {
        if ( usersRepository.findById(id).isPresent() ){
            usersModel.setId(id);
            usersRepository.save(usersModel);
            responseModel.setMessage("User updated successfully");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
        } else {
            responseModel.setMessage("User not found");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.NOT_FOUND);
        }
    }

    // delete user
    public ResponseEntity<?> deleteUser(Long id) {
        if (usersRepository.findById(id).isPresent()) {
            usersRepository.deleteById(id);
            responseModel.setMessage("User deleted successfully");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.OK);
        } else {
            responseModel.setMessage("User not found");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        }
    }
}
