package com.accolite.restapi_au.service.impl;

import com.accolite.restapi_au.entity.PrivateMessage;
import com.accolite.restapi_au.repository.PrivateMessageRepository;
import com.accolite.restapi_au.service.PrivateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class PrivateMessageServiceImpl implements PrivateMessageService {

    @Autowired
    PrivateMessageRepository privateMessageRepository;

    @Override
    public PrivateMessage add(PrivateMessage privateMessage) {
        privateMessage.setCreatedTime(new Timestamp(System.currentTimeMillis()));
        return privateMessageRepository.save(privateMessage);
    }

    @Override
    public List<PrivateMessage> getMessages(Integer userId) {
        return privateMessageRepository.findByUserIdOrderByIdDesc(userId);
    }

    @Override
    public String deleteMessage(Integer id){
        Optional<PrivateMessage> privateMessage = privateMessageRepository.findById(id);
        if(!privateMessage.isPresent())
            return "Message not found!";

        privateMessageRepository.deleteById(id);
        return "Successfully Deleted!";
    }
    }
