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

	@JsonRawValue
	@JsonProperty("IsDeleted")
	String IsDeleted;

	@JsonRawValue
	@JsonProperty("IsTracked")
	String IsTracked;

	@JsonRawValue
	@JsonProperty("Incoming")
	String Incoming;

	@JsonRawValue
	@JsonProperty("IsBounced")
	String IsBounced;

	@JsonRawValue
	@JsonProperty("IsExternallyVisible")
	String IsExternallyVisible;

	@JsonRawValue
	@JsonProperty("IsClientManaged")
	String IsClientManaged;

	@JsonRawValue
	@JsonProperty("HasAttachment")
	String HasAttachment;

	@JsonRawValue
	@JsonProperty("IsOpened")
	String IsOpened;

	@JsonRawValue
	@JsonProperty("IsPrivateDraft")
	String IsPrivateDraft;

}
