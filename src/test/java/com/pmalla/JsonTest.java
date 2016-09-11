/**
 *
 */
package com.pmalla;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pmalla.dto.profile.Profile;

/**
 * @author pmalla
 *
 */
public class JsonTest {
	private static final Logger logger = Logger.getLogger(JsonTest.class.getName());
	private static final String JSON_FILE_PATH = "ct.json";
	String jsonString;

	@Test
	public void testReadJson() throws URISyntaxException, JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		File jsonFile = new File(JsonTest.class.getClassLoader().getResource(JSON_FILE_PATH).toURI());
		if (jsonFile.exists()) {
			logger.info(jsonFile.getAbsolutePath());
			JsonNode root = mapper.readTree(jsonFile);
			logger.info("The JSON from file is " + root.toString());
			Profile profile = mapper.readValue(jsonFile, Profile.class);
			logger.info("The POJO is " + profile.toString());
		}
	}

}
