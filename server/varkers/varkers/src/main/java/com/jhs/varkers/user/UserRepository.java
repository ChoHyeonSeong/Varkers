package com.jhs.varkers.user;

import java.util.List;

public interface UserRepository {
    boolean insert(UserDTO dto);
    boolean update(UserDTO dto);
    boolean delete(long id);
    UserDTO select(long id);
    List<UserDTO> selectAll();
}
