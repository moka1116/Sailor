package com.sailor.mailer.JWT;

import com.sailor.mailer.services.KeyRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Component
class KeyTransformer implements KeyRetriever {

	public KeyReader keyReader;

	@Autowired
	public KeyTransformer(KeyReader keyReader) {
		this.keyReader = keyReader;
	}

	@Override
	public Key getKey() {
		String KEY = keyReader.retrieveKey();
		String privateKey = KEY.replace("-----BEGIN PRIVATE KEY-----", "");
		privateKey = privateKey.replace("-----END PRIVATE KEY-----", "");
		privateKey = privateKey.replaceAll("\\s+", "");

		byte[] decode = Base64.getDecoder().decode(privateKey);
		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decode);
		try {
			KeyFactory kf = KeyFactory.getInstance("RSA");
			return kf.generatePrivate(keySpec);
		} catch (Exception e) {
			throw new RuntimeException("Exception during key generation");
		}
	}
}

