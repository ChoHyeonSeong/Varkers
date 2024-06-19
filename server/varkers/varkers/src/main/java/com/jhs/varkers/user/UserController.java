package com.jhs.varkers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signin")
    public UserDTO signIn(@RequestBody UserDTO dto) {
        return userService.getUser(dto.getEmail(), dto.getPassword());
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody UserDTO user) {
        System.out.println(user);
        userService.insertUser(user);
        return "OK";
    }
}
