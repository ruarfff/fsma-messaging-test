/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.receiver;

import javax.jms.Message;
import javax.jms.MessageListener;

import com.emc.psasss.tools.fsma.messaging.model.ReportingMessage;
import com.emc.psasss.tools.fsma.messaging.util.JsonMessageUtility;


public abstract class ReportingMessageReceiver  implements MessageListener {
	
	@Override
	public void onMessage(Message message) { 
		ReportingMessage reportingMessage = JsonMessageUtility.convertObjectFromBody(message, ReportingMessage.class);
		onReportingMessage(reportingMessage);
	}
	
	abstract public void onReportingMessage(ReportingMessage reportingMessage);

}
