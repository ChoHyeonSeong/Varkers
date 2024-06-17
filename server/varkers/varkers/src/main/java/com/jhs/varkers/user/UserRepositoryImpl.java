package com.jhs.varkers.user;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Transactional
public class UserRepositoryImpl implements UserRepository {
    private final EntityManager em;

    @Override
    public boolean insert(UserDTO dto) {
        return false;
    }

    @Override
    public boolean update(UserDTO dto) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public UserDTO select(long id) {
        return null;
    }

    @Override
    public List<UserDTO> selectAll() {
        return List.of();
    }
}
