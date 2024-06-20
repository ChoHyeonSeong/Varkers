package com.jhs.varkers.user;

public interface UserDAO {
    void createUser(UserEntity user);
    UserEntity readUserByEmail(String email);
}
