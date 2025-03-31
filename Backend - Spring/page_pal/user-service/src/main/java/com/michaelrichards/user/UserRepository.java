package com.michaelrichards.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);

    @Query(name = "FIND_USER_BY_PUBLIC_ID")
    List<User> findByPublicId(String public_Id);

    @Query(name = "FIND_ALL_USERS_EXCEPT_SELF")
    List<User> findAllUsersExceptSelf(@Param("publicId") String senderId);
}
