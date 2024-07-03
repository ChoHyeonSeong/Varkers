package com.jhs.varkers.receiver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReceiverDTO {
    private Long varkId;
    private List<Long> accountIds;
}
