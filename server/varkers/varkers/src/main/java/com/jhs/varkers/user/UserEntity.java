package com.jhs.varkers.user;

import com.jhs.varkers.account.AccountEntity;
import jakarta.persistence.*;
import jdk.dynalink.linker.LinkerServices;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String email;
    private String password;
    private int maxAccountCount;
    private Long currentAccountId;
    private Date birth;
    @CreationTimestamp
    private Date createdAt;


    public void updateCurrentAccountId(Long currentAccountId) {
        this.currentAccountId = currentAccountId;
    }
}
