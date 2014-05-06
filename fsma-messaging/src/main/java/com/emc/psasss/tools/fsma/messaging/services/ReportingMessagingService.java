/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emc.psasss.tools.fsma.messaging.model.DestinationEnums;
import com.emc.psasss.tools.fsma.messaging.model.ReportingMessage;
import com.emc.psasss.tools.fsma.messaging.producer.MessageSender;

@Service("reportingMessagingService")
public class ReportingMessagingService {

	/**
	 * Service to send messages
	 */
	@Autowired
	protected MessageSender messageSender;

	/**
	 * Send a message to execute a report
	 * 
	 * @param name
	 * @param uploadedFilePath
	 * @param rawDataId
	 * @throws Exception
	 */
	public void initiateReport(String name, String uploadedFilePath,
			String rawDataId) throws Exception {
		ReportingMessage reportingMessage = new ReportingMessage(name, uploadedFilePath, rawDataId);
		messageSender.sendMessage(DestinationEnums.FSMA_REPORT,
				reportingMessage);
	}
	
	/**
	 * Sends a message to execute a report
	 * 
	 * @param reportingMessage
	 * @throws Exception
	 */
	public void initiateReport(ReportingMessage reportingMessage) throws Exception {		
		messageSender.sendMessage(DestinationEnums.FSMA_REPORT,
				reportingMessage);
	}

	/**
	 * The getter for messageSender
	 * 
	 * @return the messageSender
	 */
	public MessageSender getMessageSender() {
		return messageSender;
	}

	/**
	 * The setter for messageSender
	 * 
	 * @param messageSender
	 *            the messageSender to set
	 */
	public void setMessageSender(MessageSender messageSender) {
		this.messageSender = messageSender;
	}

}
