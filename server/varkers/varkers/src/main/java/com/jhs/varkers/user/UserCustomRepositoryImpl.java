package com.jhs.varkers.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.jhs.varkers.user.QUserEntity.userEntity;

@Repository
@RequiredArgsConstructor
public class UserCustomRepositoryImpl implements UserCustomRepository {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public UserEntity findUserByEmail(String email) {
        return jpaQueryFactory
                .selectFrom(userEntity)
                .where(userEntity.email
                        .eq(email)).
                fetchFirst();
    }
}
