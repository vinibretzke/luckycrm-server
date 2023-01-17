package com.bretzke.luckycrm.service;

import com.bretzke.luckycrm.model.Users;
import com.bretzke.luckycrm.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    private PasswordEncoder passwordEncoder;
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users createUser(Users user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Users getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public Users updateUser(Long id, Users user) {
        Users existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(this.passwordEncoder.encode(user.getPassword()));
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    //create login method
    public void login(String username, String password) {
        Users user = userRepository.findByUsername(username);
        if (user != null) {
            if (this.passwordEncoder.matches(password, user.getPassword())) {
                System.out.println("Login successful");
            } else {
                System.out.println("Login failed");
            }
        } else {
            System.out.println("Login failed");
        }
    }
}
