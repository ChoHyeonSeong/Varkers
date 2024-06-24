package com.jhs.varkers.vark;

import java.util.List;

public interface VarkCustomRepository {
    List<VarkEntity> findByListening(List<Long> listeningList);
}
