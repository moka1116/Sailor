package com.sailor.mailer.JWT;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
@RequiredArgsConstructor
@Slf4j
public class KeyReader {
	private static final Logger logger = LoggerFactory.getLogger(KeyReader.class);

	public String retrieveKey() {
		StringBuilder pemKey = new StringBuilder();
		String fileName = "key.pem";

		String line = null;

		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			while ((line = bufferedReader.readLine()) != null) {
				pemKey.append(line);
			}

			bufferedReader.close();
		} catch (FileNotFoundException ex) {
			logger.error("Unable to open file '" + fileName + "'");
		} catch (IOException ex) {
			logger.error("Error reading file '" + fileName + "'");
		}
		return pemKey.toString();
	}
}
