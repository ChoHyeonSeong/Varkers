package com.jhs.varkers.listening;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListeningDTO {
    private Long id;
    private Long accountId;
    private Long listeningId;
}
