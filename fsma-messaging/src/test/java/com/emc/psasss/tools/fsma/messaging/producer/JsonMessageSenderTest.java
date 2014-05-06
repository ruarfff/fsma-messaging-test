/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.producer;

import java.util.ArrayList;
import java.util.List;

import javax.jms.JMSException;
import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import com.emc.psasss.tools.fsma.messaging.model.DestinationEnums;
import com.emc.psasss.tools.fsma.messaging.model.ReportingMessage;

public class JsonMessageSenderTest {

	private JmsTemplate mockJmsTemplate;

	private JsonMessageSender messageSender;

	@Before
	public void setup() {
		mockJmsTemplate = EasyMock.createStrictMock(JmsTemplate.class);
		messageSender = new JsonMessageSender();
		messageSender.setJmsTemplate(mockJmsTemplate);
		List<Queue> queues = new ArrayList<Queue>();
		ActiveMQQueue reportQueue = new ActiveMQQueue(
				DestinationEnums.FSMA_REPORT.toString());
		queues.add(reportQueue);
		messageSender.setQueues(queues);
	}

	@Test(expected = RuntimeException.class)
	public void testNoQueue() throws JMSException {
		messageSender.setQueues(null);
		messageSender.sendMessage(DestinationEnums.FSMA_REPORT, null);
	}

	@Test
	public void testQueue() throws JMSException {
		mockJmsTemplate.send(EasyMock.anyObject(Queue.class),
				 EasyMock.anyObject(MessageCreator.class));
		EasyMock.expectLastCall();
		EasyMock.replay(mockJmsTemplate);
		messageSender.sendMessage(DestinationEnums.FSMA_REPORT,
				new ReportingMessage());
		EasyMock.verify(mockJmsTemplate);
	}

}
