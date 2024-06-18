package com.jhs.varkers.user;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="user")
public class UserEntity {
    @Id
    @GeneratedValue
    private long id;
    private String email;
    private String password;
    private Date birth;
    private int max_account;
    @CreationTimestamp
    private Date created_at;
}
