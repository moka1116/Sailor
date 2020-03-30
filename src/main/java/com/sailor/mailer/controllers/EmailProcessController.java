package com.sailor.mailer.controllers;

import com.sailor.mailer.servicesImpl.MailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Map;

@RestController
public class EmailProcessController {

	private final MailServiceImpl mailSender;

	@Autowired
	public EmailProcessController(MailServiceImpl mailSender) {
		this.mailSender = mailSender;
	}

	@PostMapping(value = "/mail")
	public String sendEmail(@RequestBody Map<String, String> jsonMap) throws IOException, MessagingException {
		mailSender.sendMail(jsonMap.toString());
		return "Email sent successfully";
	}


}

