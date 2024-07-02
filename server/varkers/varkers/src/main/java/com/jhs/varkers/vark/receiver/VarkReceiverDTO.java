package com.jhs.varkers.vark.receiver;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VarkReceiverDTO {
    private Long id;
    private Long varkId;
    private Long accountId;
}
