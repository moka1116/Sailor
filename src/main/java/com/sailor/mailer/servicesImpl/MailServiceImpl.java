package com.sailor.mailer.servicesImpl;

import com.sailor.mailer.configuration.MailConfiguration;
import com.sailor.mailer.services.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailServiceImpl implements MailService {

	private final MailConfiguration mailConfiguration;

	public void sendMail(String tst) throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", mailConfiguration.getAuth());
		props.put("mail.smtp.starttls.enable", mailConfiguration.getEnableTls());
		props.put("mail.smtp.host", mailConfiguration.getHost());
		props.put("mail.smtp.port", mailConfiguration.getPort());

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailConfiguration.getUser(), mailConfiguration.getPassword());
			}
		});

		Message msg = new MimeMessage(session);

		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ka.motyka@o2.pl"));
		msg.setSubject("Tutorials point email");
		msg.setContent("Tutorials point email", "text/html");
		msg.setSentDate(new Date());

		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent(tst, "text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		msg.setContent(multipart);
		Transport.send(msg);
	}

}
