package com.sailor.mailer.services;

import javax.mail.MessagingException;
import java.io.IOException;

public interface MailService {
	void sendMail(String tst) throws MessagingException, IOException;
}
