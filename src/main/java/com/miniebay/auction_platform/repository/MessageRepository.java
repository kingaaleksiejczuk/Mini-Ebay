package com.miniebay.auction_platform.repository;

import com.miniebay.auction_platform.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import com.miniebay.auction_platform.entity.User;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> getMessagesByToUser(User user);
}
