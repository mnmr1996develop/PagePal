package com.michaelrichards.service;

import com.michaelrichards.dto.UserResponse;
import com.michaelrichards.user.User;
import com.michaelrichards.user.UserMapper;
import com.michaelrichards.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;


    public List<UserResponse> getAllUsersExceptSelf(Authentication connectedUser){
        return userRepository.findAllUsersExceptSelf(connectedUser.getName())
                .stream()
                .map(userMapper::toUserResponse)
                .toList();
    }
}
