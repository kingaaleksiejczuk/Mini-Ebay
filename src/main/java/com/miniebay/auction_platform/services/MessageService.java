package com.miniebay.auction_platform.services;

import com.miniebay.auction_platform.entity.Message;
import com.miniebay.auction_platform.entity.User;

import java.util.List;

public interface MessageService {

    List<Message> getMessagesByToUser(User user);

    int getUnreadMessagesByUser(User user);

    Message getMessageById(Long id);

    void saveMessage(Message message);
}
