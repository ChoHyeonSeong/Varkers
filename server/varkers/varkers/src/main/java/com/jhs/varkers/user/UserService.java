package com.jhs.varkers.user;

import java.util.List;

public interface UserService {
    void insert(UserDTO dto);
    UserDTO read(long id);
}
