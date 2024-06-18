package com.jhs.varkers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signin")
    public String signIn(String email, String password) {
        UserDTO user = userService.getUser(email,password);
        return user!=null?"exist user":"null user";
    }

    @PostMapping("/signup")
    public String signUp() {
        //UserDTO dto
        String result = "";
        System.out.println("signup 작동");
        return result;
    }
}
