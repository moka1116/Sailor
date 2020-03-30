package com.sailor.mailer.DAO;

import lombok.AllArgsConstructor;
import lombok.Value;

@AllArgsConstructor
@Value
public class EmailMessage {

	public String plainTextBody;

}
