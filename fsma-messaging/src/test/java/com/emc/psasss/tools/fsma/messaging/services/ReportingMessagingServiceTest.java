/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.services;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.emc.psasss.tools.fsma.messaging.MessagingTestUtility;
import com.emc.psasss.tools.fsma.messaging.model.ReportingMessage;
import com.emc.psasss.tools.fsma.messaging.producer.MessageSender;
import com.emc.psasss.tools.fsma.messaging.receiver.ReportingMessageReceiver;

@ContextConfiguration(locations = {
		"/messaging-contexts/embedded-broker-context.xml",
		"/messaging-contexts/messaging-context.xml"
		})
@RunWith(SpringJUnit4ClassRunner.class)
public class ReportingMessagingServiceTest {

	/**
	 * {@link ReportingMessagingService}
	 */
	@Autowired
	private ReportingMessagingService reportingMessagingService;
	
	//@Autowired
//	private ReportingMessageReceiver reportingMessageReceiver;
	
	 /**
     * Mock {@link MessageSender}
     */
    private MessageSender mockMessageSender;
	
	
	
	@Test
	public void testReportInitiation() throws Exception {	
		ReportingMessage expected = MessagingTestUtility.createReportingMessage();
		mockMessageSender = EasyMock.createStrictMock(MessageSender.class);
		reportingMessagingService.setMessageSender(mockMessageSender);
		reportingMessagingService.initiateReport(expected);		
	}

}
