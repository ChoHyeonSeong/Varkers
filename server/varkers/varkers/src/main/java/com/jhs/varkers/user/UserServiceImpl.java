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
    public void insertUser(UserDTO dto) {
        dao.insertUser(mapper.map(dto, UserEntity.class));
    }

    @Override
    public UserDTO getUser(String email, String password) {
        UserEntity user = dao.getUserByEmail(email);
        return user != null && user.getPassword().equals(password)? mapper.map(user, UserDTO.class):null;
    }
}
