/*
package com.phearun.rest.pub;

import com.phearun.model.Message;
import com.phearun.repository.MessageRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public/messages")
public class MessagePublicController {

	private MessageRepository messageRepository;

	public MessagePublicController(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@RequestMapping
	public List<Message> findAll() {
		return messageRepository.findAll();
	}

	@GetMapping("/{id}")
	public Message findMessage(@PathVariable Integer id) {
		return messageRepository.findOne(id);
	}

}
*/
