package com.sailor.mailer.JWT;

import com.sailor.mailer.configuration.MailConfiguration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@Service
@RequiredArgsConstructor
@Slf4j
public class SessionEstablisher {

	private final MailConfiguration mailConfiguration;
//	private static final Logger logger = LoggerFactory.getLogger(SessionEstablisher.class);

	public Session establishSession(){
		Properties props = new Properties();
		props.put("mail.smtp.auth", mailConfiguration.getAuth());
		props.put("mail.smtp.starttls.enable", mailConfiguration.getEnableTls());
		props.put("mail.smtp.host", mailConfiguration.getHost());
		props.put("mail.properties.mail.smtp.connectiontimeout", 10000);
		props.put("mail.properties.mail.smtp.timeout", 10000);
		props.put("mail.properties.mail.smtp.writetimeout", 10000);

		return Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(mailConfiguration.getUser(), mailConfiguration.getPassword());
			}
		});
	}

}
