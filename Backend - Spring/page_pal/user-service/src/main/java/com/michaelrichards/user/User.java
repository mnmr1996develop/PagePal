package com.michaelrichards.user;

import com.michaelrichards.common.BaseAuditingEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(
     name = "FIND_ALL_USERS_EXCEPT_SELF",
     query = "SELECT u FROM User u WHERE u.id != :publicId"
)
@NamedQuery(
        name = "FIND_USER_BY_PUBLIC_ID",
        query = "SELECT u FROM User u WHERE u.id = :publicId"
)
public class User extends BaseAuditingEntity {

    private static final int LAST_ACTIVE_INTERVAL = 5;

    @Id
    private String id;

    private String firstName;

    private String lastName;

    private String username;

    private String email;

    private LocalDate birthday;

    private LocalDateTime lastSeen;

    @Transient
    public boolean isUserOnline() {
        return lastSeen != null && lastSeen.isAfter(LocalDateTime.now().minusMinutes(LAST_ACTIVE_INTERVAL));
    }
}
