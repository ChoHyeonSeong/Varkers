package com.jhs.varkers.vark;

import com.jhs.varkers.account.AccountDAO;
import com.jhs.varkers.account.AccountEntity;
import com.jhs.varkers.account.AccountService;
import com.jhs.varkers.listening.ListeningDTO;
import com.jhs.varkers.listening.ListeningEntity;
import com.jhs.varkers.listening.ListeningService;
import com.jhs.varkers.notification.NotificationService;
import com.jhs.varkers.receiver.ReceiverDTO;
import com.jhs.varkers.receiver.ReceiverService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class VarkServiceImpl implements VarkService {
    private final VarkDAO dao;
    private final NotificationService notificationService;
    private final ListeningService listeningService;
    private final ModelMapper mapper;


    @Override
    public VarkDTO createVark(VarkDTO dto) {
        // 엔티티 생성
        VarkEntity entity = mapper.map(dto, VarkEntity.class);
        dao.createVark(entity);
        return mapper.map(entity, VarkDTO.class);
    }

    @Override
    public VarkDTO readVark(Long id) {
        return mapper.map(dao.readVark(id),VarkDTO.class);
    }

    @Override
    public List<VarkDTO> readVarkOfAccount(Long accountId) {
        return dao.readVarkOfAccount(accountId)
                .stream()
                .map(e->mapper.map(e,VarkDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteVark(Long id) {
        dao.deleteVark(id);
    }

    @Override
    public List<VarkDTO> readVarkRoad(Long accountId) {
        List<Long> listeningList = listeningService.readByAccountId(accountId)
                .stream()
                .map(ListeningDTO::getListeningId)
                .collect(Collectors.toList());
        listeningList.add(accountId);

        return dao.readVarkRoad(listeningList)
                .stream()
                .map(e->mapper.map(e,VarkDTO.class))
                .collect(Collectors.toList());
    }
}
