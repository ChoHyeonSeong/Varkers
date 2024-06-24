package com.jhs.varkers.vark;

import java.util.List;

public interface VarkService {
    void createVark(VarkDTO dto);
    VarkDTO readVark(Long id);
    void deleteVark(Long id);
    List<VarkDTO> readVarkOfAccount(Long accountId);
    List<VarkDTO> readVarkRoad(Long accountId);
}
