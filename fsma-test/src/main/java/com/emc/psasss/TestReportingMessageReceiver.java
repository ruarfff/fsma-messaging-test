package com.emc.psasss;

import org.springframework.stereotype.Component;

import com.emc.psasss.tools.fsma.messaging.model.ReportingMessage;
import com.emc.psasss.tools.fsma.messaging.receiver.ReportingMessageReceiver;

@Component("reportingMessageReceiver")
public class TestReportingMessageReceiver extends ReportingMessageReceiver {

	@Override
	public void onReportingMessage(ReportingMessage reportingMessage) {
		System.out.println(reportingMessage.toString());
	}

}
