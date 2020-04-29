package com.sailor.mailer.controllers;

import com.sailor.mailer.DAO.EmailMessage;
import com.sailor.mailer.JWT.KeyReader;
import com.sailor.mailer.servicesImpl.MailServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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
	public String sendEmail(@RequestParam String content) throws IOException, MessagingException {
		logger.warn(content.toString());
		//mailSender.sendMail(content);
		return "Email sent successfully";
	}

	@RequestMapping(value = "/mailer", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String tests(@RequestBody EmailMessage content) throws IOException, MessagingException {
		logger.warn(content.toString());
		mailSender.sendMail(content);
		return "Email sent successfully";
	}

}

