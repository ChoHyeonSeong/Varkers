package com.jhs.varkers.listening;

import com.jhs.varkers.account.AccountEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "listening")
public class ListeningEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountEntity account;
    private Long listeningId;
}
