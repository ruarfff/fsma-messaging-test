/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.producer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.log4j.Logger;
import org.springframework.jms.core.MessageCreator;

import com.emc.psasss.tools.fsma.messaging.util.JsonMessageUtility;

/**
 * Implementation of the {@link MessageCreator} that creates a message with the
 * passed object as json text in the message body
 */
public class JsonMessageCreator implements MessageCreator {

	private static final Logger LOGGER = Logger
			.getLogger(JsonMessageCreator.class);

	/**
	 * Message object to convert as message body
	 */
	private Object message;

	/**
	 * Constructor that passed in a message
	 * 
	 * @param message
	 *            to set as text body
	 */
	public JsonMessageCreator(Object message) {
		this.message = message;
	}

	@Override
	public Message createMessage(Session session) throws JMSException {
		try {
			String messageText = JsonMessageUtility
					.convertObjectToJsonString(message);

			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug(messageText);
			}
			return session.createTextMessage(messageText);
		} catch (Exception e) {
			throw new RuntimeException(
					"Error creating message for remediation", e);
		}
	}

}
