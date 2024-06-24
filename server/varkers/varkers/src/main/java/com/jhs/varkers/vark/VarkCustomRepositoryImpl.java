package com.jhs.varkers.vark;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import static com.jhs.varkers.vark.QVarkEntity.varkEntity;
import static com.jhs.varkers.account.QAccountEntity.accountEntity;

import java.util.List;

@RequiredArgsConstructor
public class VarkCustomRepositoryImpl implements VarkCustomRepository{
    private final JPAQueryFactory factory;

    @Override
    public List<VarkEntity> findByListening(List<Long> listeningList) {
        return factory
                .selectFrom(varkEntity)
                .join(varkEntity.account, accountEntity)
                .where(accountEntity.id.in(listeningList))
                .orderBy(varkEntity.id.desc())
                .limit(50L)
                .fetch();
    }
}
