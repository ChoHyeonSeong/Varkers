package com.jhs.varkers.vark;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VarkServiceImpl implements VarkService {
    private final VarkDAO dao;
    private final ModelMapper mapper;

    @Override
    public void createVark(VarkDTO dto) {
        dao.createVark(mapper.map(dto,VarkEntity.class));
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
