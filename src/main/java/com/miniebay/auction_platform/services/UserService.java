package com.miniebay.auction_platform.services;

import com.miniebay.auction_platform.entity.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    Optional<User> getUserByEmail(String email);

    List<User> getAllUsers();

    List<User> getAllUsersOtherThanLoggedIn(User user);

    void saveUser(User user);

    User getUserById(Long id);

    Long isEmailUnique(String email);

    Long isUserUnique(String username);

}
