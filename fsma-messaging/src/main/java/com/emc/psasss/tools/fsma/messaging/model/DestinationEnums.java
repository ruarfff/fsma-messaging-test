/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.model;

/**
 * Enums for known destination queues
 */
public enum DestinationEnums {

	/**
	 * Available destinations in FSMA
	 * <ul>
	 * <li>Report queue</li>
	 * </ul>
	 * <p>
	 * The actual queue objects are defined in the
	 * messaging-contexts/messaging-context.xml file (for in memory queues)
	 */

	FSMA_EXCEL_REPORT("emc.psasss.fsma.report.excel"), FSMA_WORD_REPORT("emc.psasss.fsma.report.word");

	/**
	 * The name/address of the queue we wish to send to
	 */
	private final String value;

	/**
	 * Construct a queue
	 * 
	 * @param value
	 *            of the queue
	 */
	private DestinationEnums(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return value;
	}
}
