package com.miniebay.auction_platform.helper;

import com.miniebay.auction_platform.entity.Role;
import com.miniebay.auction_platform.entity.User;
import com.miniebay.auction_platform.services.UserService;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.security.Principal;
import java.util.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class DataHelper {

    private final UserService userService;

    public DataHelper(UserService userService) {
        this.userService = userService;
    }

    public User getUserSendToView(Principal principal, Model model) {
        if (principal != null) {
            Optional<User> findUser = userService.getUserByEmail(principal.getName());
            if (findUser.isPresent()) {
                User user = findUser.get();
                user.setLogged(1);
                model.addAttribute("user", user);
                return user;
            }
        }
        return null;
    }

    public boolean isEmailUnique(String email) {
        Long userCount = userService.isEmailUnique(email);
        return userCount > 0 ? false : true;
    }

    public void saveNewUser(User user) {
        Set<Role> roles = new HashSet<>();
        roles.add(Role.USER);
        user.setRoles(roles);
        user.setJoined(new Date());
        user.setBalance(10000);
        userService.saveUser(user);
    }

    public void saveUser(User user) {
        userService.saveUser(user);
    }
}
