/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.util;

import javax.jms.TextMessage;

import junit.framework.TestCase;

import org.easymock.EasyMock;
import org.junit.Test;

import com.emc.psasss.tools.fsma.messaging.MessagingTestUtility;
import com.emc.psasss.tools.fsma.messaging.model.ReportingMessage;

public class JsonMessageUtilityTest {

	/**
	 * Mock RemediationMessage
	 */
	private ReportingMessage mockReportingMessage = EasyMock
			.createMock(ReportingMessage.class);

	/**
	 * Test that convertObjectFromBody successfully converts a test
	 * {@link ReportingMessage} from the body of a test text message
	 * 
	 * @throws Exception
	 *             if any unexpected error occurs
	 */
	@Test
	public void testConvertObjectFromBody() throws Exception {
		ReportingMessage expected = MessagingTestUtility
				.createReportingMessage();
		TextMessage message = MessagingTestUtility
				.createJMSTextMessage(expected);
		ReportingMessage result = JsonMessageUtility.convertObjectFromBody(
				message, ReportingMessage.class);
		TestCase.assertEquals(expected.getName(), result.getName());
		TestCase.assertEquals(expected.getRawDataId(), result.getRawDataId());
		TestCase.assertEquals(expected.getUploadedFilePath(),
				result.getUploadedFilePath());
	}

	/**
	 * Test that an exception is thrown and bubbled up if the specified class
	 * does not match the object represented by the Json string in the message
	 * body
	 * 
	 * @throws Exception
	 *             if any unexpected error occurs
	 */
	@Test(expected = RuntimeException.class)
	public void testConvertObjectFromBodyException() throws Exception {
		new JsonMessageUtility();
		TextMessage message = MessagingTestUtility
				.createJMSTextMessage(MessagingTestUtility
						.createReportingMessage());
		JsonMessageUtility.convertObjectFromBody(message, String.class);
	}

	/**
	 * Test that the convertObjectToJsonString successfully converts a String to
	 * the test {@link ReportingMessage}
	 * 
	 * @throws Exception
	 *             if any unexpected error occurs
	 */
	@Test
	public void testConvertJsonStringToObject() throws Exception {
		ReportingMessage expected = MessagingTestUtility
				.createReportingMessage();

		String jsonString = MessagingTestUtility.mapper
				.writeValueAsString(expected);

		ReportingMessage result = JsonMessageUtility.convertJsonStringToObject(
				jsonString, ReportingMessage.class);

		TestCase.assertEquals(expected.getName(), result.getName());
		TestCase.assertEquals(expected.getRawDataId(), result.getRawDataId());
		TestCase.assertEquals(expected.getUploadedFilePath(),
				result.getUploadedFilePath());
	}

	/**
	 * Test convertObjectToJsonString when some exception occurs
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test(expected = RuntimeException.class)
	public void testConvertObjectToJsonStringException() throws Exception {
		EasyMock.expect(mockReportingMessage.getName()).andThrow(
				new RuntimeException("Exception"));
		EasyMock.replay(mockReportingMessage);

		JsonMessageUtility.convertObjectToJsonString(mockReportingMessage);

		EasyMock.verify(mockReportingMessage);
	}
}
