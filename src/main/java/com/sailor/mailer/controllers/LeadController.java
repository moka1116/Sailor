package com.sailor.mailer.controllers;

import com.sailor.mailer.servicesImpl.SalesforceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class LeadController {

	private final SalesforceServiceImpl facade;


	@PostMapping(value = "/test")
	String createLead(@RequestParam String company, @RequestParam String lastName) {
		facade.createLead(company, lastName);
		return "succes";
	}

	@GetMapping(value ="/Accounts")
	HttpEntity<String> getAccounts(){
	return facade.getAccounts();
	}



}
