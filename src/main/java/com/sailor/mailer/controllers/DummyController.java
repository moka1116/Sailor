package com.sailor.mailer.controllers;

import com.sailor.mailer.JWT.KeyReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DummyController {

	private final KeyReader keyReader;

	@Autowired
	public DummyController(KeyReader keyReader) {
		this.keyReader = keyReader;
	}

	@GetMapping(value = "/keyRetrieverTest")
	public String keyRetrieverTest() {
		return keyReader.retrieveKey();
	}

}
