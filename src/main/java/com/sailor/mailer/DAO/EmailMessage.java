package com.sailor.mailer.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRawValue;
import lombok.Data;
import lombok.Value;

@Data
@Value
public class EmailMessage {

	@JsonRawValue
	@JsonProperty("Subject")
	String subject;


}
