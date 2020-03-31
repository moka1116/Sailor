package com.sailor.mailer.controllers;

import com.sailor.mailer.DAO.EmailMessage;
import com.sailor.mailer.JWT.KeyReader;
import com.sailor.mailer.servicesImpl.MailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class EmailProcessController {
	private static final Logger logger = LoggerFactory.getLogger(KeyReader.class);

	private final MailServiceImpl mailSender;

	@Autowired
	public EmailProcessController(MailServiceImpl mailSender) {
		this.mailSender = mailSender;
	}

	@PostMapping(value = "/mail")
	public String sendEmail(@RequestBody EmailMessage content) throws IOException, MessagingException {
		logger.warn(content.toString());
		//mailSender.sendMail(content);
		return "Email sent successfully";
	}


}

