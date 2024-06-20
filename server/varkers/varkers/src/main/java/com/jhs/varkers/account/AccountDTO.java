package com.jhs.varkers.account;

import com.jhs.varkers.user.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDTO {
    private Long id;
    private Long userId;
    private String profileImage;
    private String name;
    private String nickname;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;

    public AccountDTO(Long userId, String profileImage, String name, String nickname, String description) {
        this.userId = userId;
        this.profileImage = profileImage;
        this.name = name;
        this.nickname = nickname;
        this.description = description;
    }
}
