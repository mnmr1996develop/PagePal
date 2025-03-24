package com.michaelrichards.dto;

import java.time.LocalDate;

public record NewUser(
        String firstName,
        String lastName,
        String username,
        String email,
        String password,
        LocalDate birthday
) {
}
