package com.sailor.mailer.servicesImpl;

import com.sailor.mailer.DAO.EmailMessage;
import com.sailor.mailer.JWT.KeyReader;
import com.sailor.mailer.JWT.SessionEstablisher;
import com.sailor.mailer.configuration.MailConfiguration;
import com.sailor.mailer.services.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

	private final MailConfiguration mailConfiguration;
	private final SessionEstablisher sessionEstablisher;
	private static final Logger logger = LoggerFactory.getLogger(KeyReader.class);

	public void sendMail(EmailMessage emailMessage) throws AddressException, MessagingException, IOException {


		Message msg = new MimeMessage(sessionEstablisher.establishSession());

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ka.motyka@o2.pl"));
		msg.setSubject(emailMessage.getSubject());
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(emailMessage.getTextBody()+"Send by spring", "text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		msg.setContent(multipart);
		Transport.send(msg);
		logger.warn("msg send");
	}


}
