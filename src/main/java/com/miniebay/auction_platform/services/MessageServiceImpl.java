package com.miniebay.auction_platform.services;

import com.miniebay.auction_platform.entity.Message;
import com.miniebay.auction_platform.entity.User;
import com.miniebay.auction_platform.repository.MessageRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    @Override
    public List<Message> getMessagesByToUser(User user) {
        return messageRepository.getMessagesByToUser(user);
    }

    public int getUnreadMessagesByUser(User user) {
        return (int) getMessagesByToUser(user).stream()
                .filter(m -> m.getMessageRead() == 0)
                .count();

    }

    @Override
    public Message getMessageById(Long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}
