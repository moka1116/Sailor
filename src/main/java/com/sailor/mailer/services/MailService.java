package com.sailor.mailer.services;

import com.sailor.mailer.DAO.EmailMessage;

import javax.mail.MessagingException;
import java.io.IOException;

public interface MailService {
	void sendMail(EmailMessage content) throws MessagingException, IOException;
}
