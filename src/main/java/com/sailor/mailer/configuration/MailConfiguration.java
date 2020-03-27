package com.sailor.mailer.configuration;

import lombok.Value;
import lombok.experimental.NonFinal;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Value
@NonFinal
@ConstructorBinding
@ConfigurationProperties(prefix = "mailer.smtp")
@Validated
public class MailConfiguration {

	@NotBlank
	String auth;

	@NotBlank
	String enableTls;

	@NotBlank
	String host;

	@Min(1)
	int port;

	@NotBlank
	String user;

	@NotBlank
	String password;

}
