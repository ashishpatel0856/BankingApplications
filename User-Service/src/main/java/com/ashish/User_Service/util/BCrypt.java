package com.ashish.User_Service.util;

import static org.springframework.security.crypto.bcrypt.BCrypt.*;

public class BCrypt {

    public static String hash(String ss){
        return hashpw(ss,gensalt());
    }
    public static boolean match(String passwordText,String passwordHashed){
        return checkpw(passwordText,passwordHashed);
    }
}
