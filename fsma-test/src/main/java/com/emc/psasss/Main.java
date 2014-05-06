package com.emc.psasss;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import com.emc.psasss.tools.fsma.messaging.model.ReportingMessage;
import com.emc.psasss.tools.fsma.messaging.services.ReportingMessagingService;

public class Main {

	@Autowired
	private TestReportingMessageReceiver receiver;
	
	@Autowired
	private ReportingMessagingService reportingMessagingService;
	

	public static void main(String[] args) {
		Main main = new Main();
		new ApplicationContextLoader().load(main,
				"/messaging-contexts/embedded-broker-context.xml",
				"/messaging-contexts/messaging-context.xml",
				"/application-context.xml", "/jms-context.xml");
		try {
			main.reportingMessagingService.initiateReport(new ReportingMessage("Test name", "Test upload file",
					"Test raw data Id"));
		} catch (Exception e) {			 
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
			System.exit(1);
		}
		
		String whatever;

		System.out.println("Press enter to exit....\n");
		Scanner scanIn = new Scanner(System.in);
		whatever = scanIn.nextLine();

		scanIn.close();
		System.exit(0);
	}

}
