package com.phearun.rest;

import com.phearun.model.Message;
import com.phearun.repository.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/private/messages")
public class MessagePrivateController {
    private MessageRepository messageRepository;

    public MessagePrivateController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @RequestMapping
    public List<Message> findAll(){
        return messageRepository.findAll();
    }

    @GetMapping("/{id}")
    public Message findMessage(@PathVariable Integer id){
        return messageRepository.findOne(id);
    }

    @PostMapping
    public Message save(@RequestBody Message message){
        return messageRepository.save(message);
    }
}

