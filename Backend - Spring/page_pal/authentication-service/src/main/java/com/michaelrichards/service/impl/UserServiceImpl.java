package com.michaelrichards.service.impl;

import com.michaelrichards.dto.NewUser;
import com.michaelrichards.service.UserService;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Value("${app.keycloak.realm}")
    private String realm;


    private final Keycloak keycloak;

    @Override
    public void createUser(NewUser newUser) {
        UserRepresentation userRepresentation = new UserRepresentation();
        userRepresentation.setEnabled(true);


        userRepresentation.setFirstName(newUser.firstName());
        userRepresentation.setLastName(newUser.lastName());
        userRepresentation.setUsername(newUser.username());
        userRepresentation.setEmail(newUser.email());
        userRepresentation.setEmailVerified(true);

        String birthday = formatLocalDate(newUser.birthday());

        HashMap<String, List<String>> attributes = new HashMap<>();
        attributes.put("birthday", new ArrayList<>() {{
            add(birthday);
        }});


        userRepresentation.setAttributes(attributes);

        CredentialRepresentation credentialRepresentation = new CredentialRepresentation();
        credentialRepresentation.setValue(newUser.password());
        credentialRepresentation.setType(CredentialRepresentation.PASSWORD);

        userRepresentation.setCredentials(List.of(credentialRepresentation));

        UsersResource usersResource = getUserResource();

        Response response = usersResource.create(userRepresentation);

        if(!Objects.equals(201, response.getStatus())){
            throw new RuntimeException("Status code " +response.getStatus());
        }

        log.info("New user has been created");

    }

    @Override
    public void deleteUserById(String userId) {
        UsersResource usersResource = getUserResource();
        usersResource.delete(userId);
    }

    private UsersResource getUserResource(){
        return keycloak.realm(realm).users();
    }

    private String formatLocalDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return date.format(formatter);
    }
}
