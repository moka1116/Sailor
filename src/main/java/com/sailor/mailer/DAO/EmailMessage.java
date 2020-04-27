package com.sailor.mailer.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmailMessage {

	@JsonRawValue
	@JsonProperty("Subject")
	String subject;

	@JsonRawValue
	@JsonProperty("TextBody")
	String textBody;

	@JsonRawValue
	@JsonProperty("FromName")
	String fromName;

	@JsonRawValue
	@JsonProperty("FromAddress")
	String fromAddress;

	@JsonRawValue
	@JsonProperty("ToAddress")
	String toAddress;

	@JsonRawValue
	@JsonProperty("Status")
	String status;

}
