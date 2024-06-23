package com.jhs.varkers.vark;

import com.jhs.varkers.notification.NotificationService;
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
    private final ModelMapper mapper;

    private static final String SEND_CREATE_TYPE = "create";

    @Override
    public void createVark(VarkDTO dto) {
        VarkEntity entity = mapper.map(dto,VarkEntity.class);
        dao.createVark(entity);
        notificationService.sendToClient(dto.getAccountId(),mapper.map(entity,VarkDTO.class),SEND_CREATE_TYPE);
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
}
