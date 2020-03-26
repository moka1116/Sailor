package com.sailor.mailer.services;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import java.io.IOException;

public interface MailService {
	public void sendMail(String tst) throws AddressException, MessagingException, IOException;
}
