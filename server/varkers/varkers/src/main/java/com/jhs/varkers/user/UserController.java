package com.jhs.varkers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signin")
    public String signIn(@RequestBody UserDTO dto) {
        UserDTO user = userService.getUser(dto.getEmail(), dto.getPassword());
        return user!=null?"exist user":"null user";
    }

    @PostMapping("/signup")
    public String signUp(UserDTO user) {
        //userService.insertUser(user);
        System.out.println(user);
        return "";
    }
}
