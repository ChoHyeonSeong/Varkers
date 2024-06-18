package com.jhs.varkers.user;

import java.util.List;

public interface UserCustomRepository {
    UserEntity findUserByEmail(String email);
}
