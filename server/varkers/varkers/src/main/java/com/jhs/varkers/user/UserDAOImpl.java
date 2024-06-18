package com.jhs.varkers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAOImpl implements UserDAO{
    private final UserRepository repo;

    @Override
    public void insert(UserEntity user) {
        repo.save(user);
    }

    @Override
    public UserEntity read(long id) {
        return repo.findById(id).orElse(null);
    }
}
