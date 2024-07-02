package com.jhs.varkers.vark.receiver;

import java.util.List;

public interface VarkReceiverService {
    void createVarkReceiver(Long varkId, Long accountId);
    void createVarkReceivers(Long varkId, List<Long> accountIds);
    List<VarkReceiverDTO> readVarkReceivers(Long varkId);
}
