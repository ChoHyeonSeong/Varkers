package com.jhs.varkers.vark;

import com.jhs.varkers.account.AccountEntity;
import com.jhs.varkers.listening.ListeningEntity;

import java.util.List;

public interface VarkCustomRepository {
    List<VarkEntity> findByListening(List<AccountEntity> listingId);
}
