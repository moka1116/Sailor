package com.sailor.mailer.controllers;

import com.sailor.mailer.servicesImpl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class EmailProcessController {

	private final MailServiceImpl mailSender;

	@Autowired
	public EmailProcessController(MailServiceImpl mailSender) {
		this.mailSender = mailSender;
	}

	@PostMapping(value = "/mail")
	public String sendEmail(@RequestParam String content) throws IOException, MessagingException {
		mailSender.sendMail(content);
		return "Email sent successfully";
	}


}

