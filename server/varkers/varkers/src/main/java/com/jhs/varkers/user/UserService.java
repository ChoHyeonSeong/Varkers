package com.jhs.varkers.user;

import java.util.List;

public interface UserService {
    void insertUser(UserDTO dto);
    UserDTO getUser(String email, String password);
}
