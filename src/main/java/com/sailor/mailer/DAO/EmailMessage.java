package com.sailor.mailer.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class EmailMessage {

	@JsonRawValue
	@JsonProperty("Subject")
	private String subject;
	@JsonRawValue
	@JsonProperty("TextBody")
	private String textBody;
	@JsonRawValue
	@JsonProperty("FromName")
	private String fromName;
	@JsonRawValue
	@JsonProperty("FromAddress")
	private String fromAddress;
	@JsonRawValue
	@JsonProperty("ToAddress")
	private String toAddress;

}
