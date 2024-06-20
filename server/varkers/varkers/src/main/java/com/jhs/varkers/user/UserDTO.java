package com.jhs.varkers.user;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private Long id;
    private String email;
    private String password;
    private int maxAccountCount;
    private Long currentAccountId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private Date createdAt;
}
