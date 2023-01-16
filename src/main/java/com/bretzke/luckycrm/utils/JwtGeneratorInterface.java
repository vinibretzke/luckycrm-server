package com.bretzke.luckycrm.utils;


import com.bretzke.luckycrm.model.Users;

import java.util.Map;

public interface JwtGeneratorInterface {
    Map<String, String> generateToken(Users user);
}
