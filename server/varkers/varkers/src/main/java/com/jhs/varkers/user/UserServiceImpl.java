package com.jhs.varkers.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repo;

    @Override
    public boolean create(UserDTO dto) {
        return repo.insert(dto);
    }

    @Override
    public boolean update(UserDTO dto) {
        return repo.update(dto);
    }

    @Override
    public boolean delete(long id) {
        return repo.delete(id);
    }

    @Override
    public UserDTO read(long id) {
        return repo.select(id);
    }

    @Override
    public List<UserDTO> readAll() {
        return repo.selectAll();
    }
}
