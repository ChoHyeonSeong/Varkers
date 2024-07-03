package com.jhs.varkers.receiver;

import com.jhs.varkers.vark.VarkDAO;
import com.jhs.varkers.vark.VarkEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReceiverServiceImpl implements ReceiverService {
    private final ReceiverDAO dao;
    private final VarkDAO varkDao;
    private final ModelMapper mapper;

    @Override
    public void createReceivers(ReceiverDTO dto) {
        dao.createReceivers(dto.getAccountIds()
                .stream()
                .map(r-> new ReceiverEntity(null,dto.getVarkId(),r))
                .collect(Collectors.toList()));
    }

    @Override
    public ReceiverDTO readReceivers(Long varkId) {
        List<Long> accountIds= dao.readReceivers(varkId)
                .stream()
                .map(ReceiverEntity::getAccountId)
                .toList();
        return ReceiverDTO.builder().varkId(varkId).accountIds(accountIds).build();
    }
}
