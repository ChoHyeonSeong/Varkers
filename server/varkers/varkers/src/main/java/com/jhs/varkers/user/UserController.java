package com.jhs.varkers.user;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@NoArgsConstructor
@RequestMapping("/user")
public class UserController {

    @PostMapping("/signin")
    public String signIn() {
//        String email, String password
        String result = "";
        System.out.println("signin 작동");
        return result;
    }

    @PostMapping("/signup")
    public String signUp() {
        //UserDTO dto
        String result = "";
        System.out.println("signup 작동");
        return result;
    }
}
