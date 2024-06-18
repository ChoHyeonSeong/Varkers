package com.jhs.varkers.user;

public interface UserDAO {
    void insert(UserEntity user);
    UserEntity read(long id);
}
