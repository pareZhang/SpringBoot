package com.zjm;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {
   static String passwordEncoder(String password){
       PasswordEncoder encoder=new BCryptPasswordEncoder();
       return encoder.encode(password);
    }

    public static void main(String[] args) {
        String password=Test.passwordEncoder("123");
        System.out.println(password);
    }
}
