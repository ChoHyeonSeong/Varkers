package com.jhs.varkers.user;

import java.util.List;

public interface UserService {
    boolean create(UserDTO dto);
    boolean update(UserDTO dto);
    boolean delete(long id);
    UserDTO read(long id);
    List<UserDTO> readAll();
}
