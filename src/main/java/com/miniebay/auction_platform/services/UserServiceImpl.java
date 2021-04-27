package com.miniebay.auction_platform.services;

import com.miniebay.auction_platform.entity.User;
import com.miniebay.auction_platform.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getAllUsersOtherThanLoggedIn(User user) {
        List<User> result = getAllUsers().stream()
                .filter(u -> !u.equals(user))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
       return userRepository.findById(id).orElse(null);
    }

    @Override
    public Long isUserUnique(String username) {
        return userRepository.countUsersByUsername(username);
    }

    @Override
    public Long isEmailUnique(String email) {
        return userRepository.countUsersByEmail(email);
    }
}
