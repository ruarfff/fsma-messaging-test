/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging;

import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.codehaus.jackson.map.ObjectMapper;

import com.emc.psasss.tools.fsma.messaging.model.ReportingMessage;

public class MessagingTestUtility {

	public static final ObjectMapper mapper = new ObjectMapper();

	private static final String TEST_NAME = "Test name";
	/**
	 * The absolute path to the uploaded file
	 */
	private static final String TEST_UPLOAD_FILE_PATH = "Test uplaod path";

	/**
	 * Id used to track raw data upload form core
	 */
	private static final String TEST_RAW_DATA_ID = "TestRawDataId";

	/**
	 * Create a TextMessage
	 * 
	 * @return new text message with a ServiceResponseMessage as the body text
	 * @throws Exception
	 *             if error occurs
	 */
	public static TextMessage createJMSTextMessage(Object payload)
			throws Exception {
		TextMessage message = new ActiveMQTextMessage();

		message.setText(mapper.writeValueAsString(payload));
		return message;
	}

	/**
	 * Creates a test {@link ReportingMessage} with sample values
	 * 
	 * @return A basic {@link ReportingMessage} object
	 * @throws Exception
	 */
	public static ReportingMessage createReportingMessage() throws Exception {

		return new ReportingMessage(TEST_NAME, TEST_UPLOAD_FILE_PATH,
				TEST_RAW_DATA_ID);
	}

}
