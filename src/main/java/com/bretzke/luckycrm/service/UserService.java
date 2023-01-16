package com.bretzke.luckycrm.service;

import com.bretzke.luckycrm.exceptions.UserNotFoundException;
import com.bretzke.luckycrm.model.Users;

public interface UserService {
    public void saveUser(Users user);
    public Users getUserByNameAndPassword(String username, String password) throws UserNotFoundException;

}
