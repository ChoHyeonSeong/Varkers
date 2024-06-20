package com.jhs.varkers.user;

import com.jhs.varkers.account.AccountDTO;
import com.jhs.varkers.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final static int DEFAULT_MAX_ACCOUNT = 3;
    private final UserDAO dao;
    private final AccountService accountService;
    private final ModelMapper mapper;

    @Override
    public void createUser(UserDTO dto) {
        dto.setMaxAccountCount(DEFAULT_MAX_ACCOUNT);
        UserEntity entity = mapper.map(dto, UserEntity.class);
        dao.createUser(entity);
        Long accountId = accountService.createAccountAndReturnId(new AccountDTO(
                entity.getId(),
                "testImage",
                "testName",
                "testNickname",
                "testDescription"
        ));
        entity.updateCurrentAccountId(accountId);
    }

    @Override
    public UserDTO certifyUser(String email, String password) {
        UserEntity user = dao.readUserByEmail(email);
        return user != null && user.getPassword().equals(password)? mapper.map(user, UserDTO.class):null;
    }
}
