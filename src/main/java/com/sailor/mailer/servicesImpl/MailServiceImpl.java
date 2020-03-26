package com.sailor.mailer.servicesImpl;

import com.sailor.mailer.services.MailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

@Service
public class MailServiceImpl implements MailService {

	@Value("${sailor.dev.mail.smtp.user}")
	private String usr;

	@Value("${sailor.dev.mail.smtp.password}")
	private String pswd;

	public void sendMail(String tst) throws AddressException, MessagingException, IOException {
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(usr, pswd);
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
