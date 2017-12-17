package com.phearun;

import com.phearun.model.Message;
import com.phearun.repository.MessageRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.validation.MessageCodesResolver;

import java.util.Arrays;

@SpringBootApplication
public class Oauth2ResourceServerApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(Oauth2ResourceServerApplication.class, args);
	}

	private MessageRepository messageRepository;

	public Oauth2ResourceServerApplication(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	@Override
	public void run(ApplicationArguments applicationArguments) throws Exception {

		Arrays.asList("Hello!", "Hello World!").forEach(m->{
			messageRepository.save(new Message(m));
		});

	}
}
