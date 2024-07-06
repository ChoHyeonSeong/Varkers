package com.jhs.varkers.receiver;

import java.util.List;

public interface ReceiverService {
    void createReceivers(ReceiverDTO dto);
    ReceiverDTO readReceivers(Long varkId);
}
