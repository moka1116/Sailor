package com.sailor.mailer.DAO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EmailMessage {

	@JsonProperty("Name")
	public String name;
	@JsonProperty("Value")
	public String value;

	/*@JsonRawValue
	@JsonProperty("FromName")
	String fromName;
	@JsonRawValue
	@JsonProperty("FromAddress")
	String fromAddress;
	@JsonRawValue
	@JsonProperty("ToAddress")
	String toAddress;*/

}
