package com.sailor.mailer.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class EmailMessage {

	@JsonProperty("Subject")
	private String subject;
	@JsonProperty("TextBody")
	private String textBody;
	@JsonProperty("FromName")
	private String fromName;
	@JsonProperty("FromAddress")
	private String fromAddress;
	@JsonProperty("ToAddress")
	private String toAddress;

}
