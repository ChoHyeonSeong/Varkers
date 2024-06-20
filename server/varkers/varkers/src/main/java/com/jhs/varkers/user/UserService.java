package com.jhs.varkers.user;

public interface UserService {
    void createUser(UserDTO dto);
    UserDTO certifyUser(String email, String password);
}
