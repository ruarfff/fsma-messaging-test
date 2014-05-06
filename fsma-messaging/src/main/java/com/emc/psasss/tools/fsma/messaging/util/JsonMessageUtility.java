/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.util;

import javax.jms.Message;
import javax.jms.TextMessage;
import org.codehaus.jackson.map.ObjectMapper;

/**
 * Utility class for interacting with JSON messages
 */
public class JsonMessageUtility {
	/**
	 * Jackson mapper to convert from/to json
	 */
	private static final ObjectMapper mapper = new ObjectMapper();

	/**
	 * Extract the body text from a message and un-marshall the json back to a
	 * java object
	 * 
	 * @param message
	 *            to convert to java
	 * @param valueType
	 *            class type to instantiate
	 * @return object created out of json
	 */
	public static <T> T convertObjectFromBody(Message message,
			Class<T> valueType) {
		try {
			String messageBody = ((TextMessage) message).getText();
			return convertJsonStringToObject(messageBody, valueType);
		} catch (Exception e) {
			throw new RuntimeException("Error converting message", e);
		}
	}

	/**
	 * Un-marshal the Json back to a java object of the type supplied
	 * 
	 * @param json
	 *            Json String to convert to java object
	 * @param valueType
	 *            class type to instantiate
	 * @return object created out of Json
	 */
	public static <T> T convertJsonStringToObject(String json,
			Class<T> valueType) {
		try {
			return mapper.readValue(json, valueType);
		} catch (Exception e) {
			throw new RuntimeException("Error converting Json String [" + json
					+ "] to [" + valueType.getCanonicalName() + "]", e);
		}
	}

	/**
	 * Marshal an object to a Json String
	 * 
	 * @param object
	 *            the object
	 * @return the Json String
	 */
	public static String convertObjectToJsonString(Object object) {
		try {
			String jsonText = mapper.writeValueAsString(object);

			return jsonText;
		} catch (Exception e) {
			throw new RuntimeException(
					"Error converting object to Json String [" + object + "]",
					e);
		}
	}
}
