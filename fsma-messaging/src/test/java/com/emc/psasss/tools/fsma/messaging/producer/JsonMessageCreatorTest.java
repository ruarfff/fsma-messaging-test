/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.producer;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import junit.framework.TestCase;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.emc.psasss.tools.fsma.messaging.model.ReportingMessage;

public class JsonMessageCreatorTest {

	private Session mockSession;

	@Before
	public void setup() {
		mockSession = EasyMock.createStrictMock(Session.class);

	}

	@Test
	public void testCreateMesage() throws JMSException {
		JsonMessageCreator messageCreatorImpl = new JsonMessageCreator(
				new ReportingMessage());
		ActiveMQTextMessage textMessage = new ActiveMQTextMessage();
		textMessage.setText("Mock Message");
		EasyMock.expect(
				mockSession.createTextMessage(EasyMock.anyObject(String.class)))
				.andReturn(textMessage);
		EasyMock.replay(mockSession);
		TextMessage message = (TextMessage) messageCreatorImpl
				.createMessage(mockSession);
		EasyMock.verify(mockSession);
		TestCase.assertEquals("Mock Message", message.getText());
	}

	@Test(expected = RuntimeException.class)
	public void testCreateMesageException() throws JMSException {
		JsonMessageCreator messageCreatorImpl = new JsonMessageCreator(
				new ReportingMessage());
		ActiveMQTextMessage textMessage = new ActiveMQTextMessage();
		textMessage.setText("Mock Message");
		EasyMock.expect(
				mockSession.createTextMessage(EasyMock.anyObject(String.class)))
				.andThrow(new JMSException("Error creating message"));
		EasyMock.replay(mockSession);
		messageCreatorImpl.createMessage(mockSession);
	}

}
