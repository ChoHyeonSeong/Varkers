package com.jhs.varkers.vark;

import com.jhs.varkers.account.AccountEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VarkDAOImpl implements VarkDAO {
    private final VarkRepository repo;

    @Override
    public void createVark(VarkEntity entity) {
        repo.save(entity);
    }

    @Override
    public VarkEntity readVark(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<VarkEntity> readVarkOfAccount(Long accountId) {
        return repo.findByAccountId(accountId);
    }

    @Override
    public void deleteVark(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<VarkEntity> readVarkRoad(List<AccountEntity> listeningList) {
        return List.of();
    }
}
