package com.jhs.varkers.listening;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListeningServiceImpl implements ListeningService{
    private final ListeningDAO dao;
    private final ModelMapper mapper;

    @Override
    public List<ListeningDTO> readByAccountId(Long accountId) {
        return dao.readByAccountId(accountId)
                .stream()
                .map(e->mapper.map(e, ListeningDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ListeningDTO> readByListeningId(Long listeningId) {
        return dao.readByListeningId(listeningId)
                .stream()
                .map(e->mapper.map(e, ListeningDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public ListeningDTO readByAccountIdAndListeningId(Long accountId, Long listeningId) {
        return mapper.map(dao.readByAccountIdAndListeningId(accountId, listeningId), ListeningDTO.class);
    }

    @Override
    public void deleteByAccountIdAndListeningId(Long accountId, Long listeningId) {
        dao.deleteByAccountIdAndListeningId(accountId, listeningId);
    }

    @Override
    public boolean existsByAccountIdAndListeningId(Long accountId, Long listeningId) {
        return dao.existsByAccountIdAndListeningId(accountId, listeningId);
    }
}
