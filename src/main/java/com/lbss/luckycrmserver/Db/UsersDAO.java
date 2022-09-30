package com.lbss.luckycrmserver.Db;

import com.lbss.luckycrmserver.Routes.UsersDTO;
public class UsersDAO {

    public UsersDTO Login(String username, String password) {
        UsersDTO user = new UsersDTO();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }

    public UsersDTO Register(UsersDTO user) {
        return user;
    }





}
