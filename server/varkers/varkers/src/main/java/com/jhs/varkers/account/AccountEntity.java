package com.jhs.varkers.account;

import com.jhs.varkers.listening.ListeningEntity;
import com.jhs.varkers.user.UserEntity;
import com.jhs.varkers.vark.VarkEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="account")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private Long userId;
    private String profileImage;
    private String name;
    private String nickname;
    private String description;
    @CreationTimestamp
    private Date createdAt;
    @UpdateTimestamp
    private Date updatedAt;
    private Date deletedAt;

    public void updateAccount(String name, String nickname,String profileImage, String description) {
        this.name = name;
        this.profileImage = profileImage;
        this.nickname = nickname;
        this.description = description;
    }
}
