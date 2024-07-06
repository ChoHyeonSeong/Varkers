package com.jhs.varkers.receiver;

import com.jhs.varkers.vark.VarkEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="receiver")
public class ReceiverEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private Long varkId;
    private Long accountId;
}
