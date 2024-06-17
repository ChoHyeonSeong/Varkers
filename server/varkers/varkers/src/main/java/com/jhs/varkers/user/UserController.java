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
        String result = "";

        return result;
    }

    @PostMapping("/signup")
    public String signUp(UserDTO dto) {
        String result = "";

        return result;
    }
}
