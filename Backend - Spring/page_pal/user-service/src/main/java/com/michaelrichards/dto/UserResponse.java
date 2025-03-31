package com.michaelrichards.dto;

import com.michaelrichards.user.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private String id;
    private String first_name;
    private String last_name;
    private String email;
    private String username;
    private LocalDateTime lastSeen;
    private boolean isOnline;
}
