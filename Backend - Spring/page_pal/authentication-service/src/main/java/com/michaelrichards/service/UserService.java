package com.michaelrichards.service;

import com.michaelrichards.dto.NewUser;

public interface UserService {

    void createUser(NewUser newUser);

    void deleteUserById(String userId);
}
