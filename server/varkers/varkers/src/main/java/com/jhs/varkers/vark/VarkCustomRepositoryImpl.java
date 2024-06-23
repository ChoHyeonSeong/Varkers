package com.jhs.varkers.vark;

import com.jhs.varkers.account.AccountEntity;
import com.jhs.varkers.listening.ListeningEntity;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import static com.jhs.varkers.vark.QVarkEntity.varkEntity;
import static com.jhs.varkers.listening.QListeningEntity.listeningEntity;

import java.util.List;

@RequiredArgsConstructor
public class VarkCustomRepositoryImpl implements VarkCustomRepository{
    private final JPAQueryFactory factory;

    @Override
    public List<VarkEntity> findByListening(List<AccountEntity> listingList) {

        return factory
                .selectFrom(varkEntity)
                .where(varkEntity.account.in(listingList)).fetch();
    }
}
