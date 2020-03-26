package com.sailor.mailer.servicesImpl;

import com.sailor.mailer.DAO.Account;
import com.sailor.mailer.DAO.Lead;
import com.sailor.mailer.JWT.KeyRetriever;
import com.sailor.mailer.JWT.SalesforceToken;
import com.sailor.mailer.configuration.SalesforceConfiguration;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;

import static org.springframework.http.HttpMethod.GET;

@Component
@RequiredArgsConstructor
@Slf4j
public class SalesforceServiceImpl {

	private final RestTemplate restTemplate;

	private final SalesforceConfiguration salesforceConfiguration;

	private final KeyRetriever keyRetriever;

	private SalesforceToken getToken() {
		String jwt = createJwtToken();
		return sentRequest(jwt);
	}

	private String createJwtToken() {
		LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(salesforceConfiguration.getExpirationInMinutes());
		return Jwts.builder()
				.setIssuer(salesforceConfiguration.getClientId())
				.setAudience(salesforceConfiguration.getAudience())
				.setSubject(salesforceConfiguration.getSubject())
				.setExpiration(Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant()))
				.signWith(keyRetriever.getKey())
				.compact();
	}

	SalesforceToken sentRequest(String jwt) {
		String url = UriComponentsBuilder.fromUriString(salesforceConfiguration.getAudience()).path("/services/oauth2/token")
				.queryParam("grant_type", "urn:ietf:params:oauth:grant-type:jwt-bearer")
				.queryParam("assertion", jwt)
				.toUriString();

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

		return restTemplate.postForObject(url, new HttpEntity<>(null, headers), SalesforceToken.class);
	}


	public HttpHeaders getHeader(SalesforceToken token) {
		HttpHeaders headers = new HttpHeaders();
		headers.setBearerAuth(token.getAccessToken());
		return headers;
	}


	public String createLead(String company, String lastname) {
		SalesforceToken token = getToken();
		Lead lead = new Lead(company, lastname);
		HttpEntity<Lead> leadHttpEntity = new HttpEntity<>(lead, getHeader(token));

		return restTemplate.postForObject(token.getInstanceUrl() + "/services/data/v39.0/sobjects/Lead", leadHttpEntity, String.class);

	}

	public ResponseEntity<String> getAccounts() {
	SalesforceToken token = getToken();
	HashSet<Account> accounts = new HashSet<>();

	HttpEntity<String> entity = new HttpEntity<>("body", getHeader(token));

	return restTemplate.exchange(token.getInstanceUrl() + "/services/data/v39.0/sobjects/Account", GET,entity,String.class);

	}
}
