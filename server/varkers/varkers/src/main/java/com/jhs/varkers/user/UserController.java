package com.jhs.varkers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signin")
    public UserDTO signInUser(@RequestBody UserDTO dto) {
        return userService.certifyUser(dto.getEmail(), dto.getPassword());
    }

    @PostMapping("/signup")
    public String signUpUser(@RequestBody UserDTO user) {
        System.out.println(user);
        userService.createUser(user);
        return "OK";
    }
}
