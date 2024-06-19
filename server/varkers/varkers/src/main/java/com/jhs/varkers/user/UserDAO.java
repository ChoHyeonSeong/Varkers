package com.jhs.varkers.user;

public interface UserDAO {
    void insertUser(UserEntity user);
    UserEntity getUserByEmail(String email);
}
