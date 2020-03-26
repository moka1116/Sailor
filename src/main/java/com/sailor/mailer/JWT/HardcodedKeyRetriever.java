package com.sailor.mailer.JWT;

import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

@Component
class HardcodedKeyRetriever implements KeyRetriever {

	private static final String KEY = "-----BEGIN PRIVATE KEY-----" +
			"MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDA7042Nlswhe+x\n" +
			"qD+mBf2cWAgwqgj7TNmMdgxn6jtOJVXjOVmRD7Yy2zEaj/OXZWM9QU+LxDvB+j45\n" +
			"GsBdqjZHC+2WNIFXRpj9wHyo8tULQzFUi0mDFB4mVaFc5istUxdSXwV5UxUDbMBa\n" +
			"07lT3b4ZZ7m9aihbKT1BQLk68RYQtqAYIV5sTKoW0RclWxuUrSbAkWCYaufF/bs2\n" +
			"SVUY+mtVXEJqKOW9RSQYqfNxdcvPbp89x06coCzLgpzElwS2yOKT6k/YPSDehQRl\n" +
			"g6PjuRC+dgYaKuRxH6pHy+sFKyA9hX+5pGGYpsTABUIUNq+UrujRHZciMX0P5w5N\n" +
			"/NYyQ6SLAgMBAAECggEARJZOFZOpQ0y580w+pETI7cWV08b+vmeJhxeIPYDVaGh5\n" +
			"afe/UYRmXxnxEOJP1GhkqSgIoUU3gTP23tIVxLZ36TXiVl2ABYjBZqQBLQZ2mjRe\n" +
			"2xFRJtoGBda3MJFalBhP2CaTiZfxhnAoyaEu5xOTOvDW5PFSO2YjsojR0JRYJcRH\n" +
			"HC1U5Ll4wYo0G0PQLqC+Xh4Xtg75SddIWidd/NsoRhv0QJRbCzMpUBOl+qppygLa\n" +
			"FehNVlJj5HdGrRq87ZF2zZ3EcswZ1YlL+GqgJTt6mReVc1jHeoR+cYb9zY4Exp4T\n" +
			"YetY4fqP/zvfvi0Nm70gjK8hYW3DvN+W6cVYY3cnAQKBgQD+Zi7vzi15wNAnI8pN\n" +
			"qKyGIiI21GWlRx3kv+5I1u4qYxGguaoiVZojrXWRKNAsXyLZylzJYDsaP10uGbfL\n" +
			"8DsiZGgH7q0yU85MDE4fARdrPB9ID81CoOaRLQ6Cqw/tyb3efYnw4xUkJTcty3ee\n" +
			"pklwI3xluXs+ZmblEw/5furaSwKBgQDCJhulxvMRAkOYU8HcdxnpN/RXJQ9EHOYC\n" +
			"y1zITiqGPsm3Mr21A/XCQbP/rGRvxIuiBFgtvfgXJyzNwQfEc9pr342vkUzPS7e8\n" +
			"hu9SNboyGy5M4AmFNUqlfN6ZVK4ameYnmNAFL/tmFaGLe2/BstU9JZ90yB6j/LAM\n" +
			"pXDTubP2wQKBgQDhPEdCOiE5MuUYQi/TIgvdlksEkHiOJLDq3qNyChlDngL1cmyX\n" +
			"iYK3I9R7eM8W+gQ5H1mXUYQCcSdmsY5xGXjBsnQI0eC2NkzoN9zSxnydjNWFT7hD\n" +
			"zYFV97ZpKlsoBP3+BtgiVmtZXTnFaee2pzNN/Z0d02KylKd1GbODCkOUkQKBgQCW\n" +
			"82AtrZjREaySpBSnoGaiAOJWWzcaY0mmxI0YJEZF6E2XxbjgI/sRlVopINVaXTuf\n" +
			"tbcFoZ1iCxB3zWyHnvglRUR5TASnbByoVVV/2swxJxcBqHNegcfPEV5VYxSXFC9x\n" +
			"fAvI7LyPa6QVudxzguLuzvDCsNG5+L68pmkqBUnaQQKBgHHl5xhQLEqSOKMc7AuT\n" +
			"ahrOjPWCmuphwSqEb8oR/8YcLMJYSuD+cNMX4DuEQAUqlMYXundTp+9FUxM+4AUO\n" +
			"Lv+NzoWQ6UF2+xudmf/vF07XM01dEdixH7L2eLMfF2I+K5m2X2eOYqH/Vrp81tgJ\n" +
			"CNhe+12zvW9XSvXcPnxVvv7K" +
			"-----END PRIVATE KEY-----";

	@Override
	public Key getKey() {
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

