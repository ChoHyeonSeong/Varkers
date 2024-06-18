package com.jhs.varkers.user;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserDAO dao;
    private final ModelMapper mapper;

    @Override
    public void insert(UserDTO dto) {
        dao.insert(mapper.map(dto, UserEntity.class));
    }

    @Override
    public UserDTO read(long id) {
        return mapper.map(dao.read(id), UserDTO.class);
    }
}
