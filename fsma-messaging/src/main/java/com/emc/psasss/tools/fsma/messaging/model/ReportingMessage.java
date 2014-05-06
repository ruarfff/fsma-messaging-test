/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.model;

public class ReportingMessage extends FsmaMessage {

	private static final long serialVersionUID = -7808379210228386086L;

	/**
	 * The absolute path to the uploaded file
	 */
	private String uploadedFilePath;

	/**
	 * Id used to track raw data upload from core
	 */
	private String rawDataId;

	/**
	 * @return the uploadedFilePath
	 */
	public String getUploadedFilePath() {
		return uploadedFilePath;
	}

	/**
	 * @param uploadedFilePath
	 *            the uploadedFilePath to set
	 */
	public void setUploadedFilePath(String uploadedFilePath) {
		this.uploadedFilePath = uploadedFilePath;
	}

	public String getRawDataId() {
		return rawDataId;
	}

	public void setRawDataId(String rawDataId) {
		this.rawDataId = rawDataId;
	}

	public ReportingMessage() {
	}

	/**
	 * Initialise Reporting Message 
	 * 
	 * @param name
	 * @param uploadedFilePath
	 * @param rawDataId
	 */
	public ReportingMessage(String name, String uploadedFilePath,
			String rawDataId) {
		this.name = name;
		this.uploadedFilePath = uploadedFilePath;
		this.rawDataId = rawDataId;
	}

	@Override
	public String toString() {
		return "FSMAReportingMessage:" + "\nName = " + name
				+ "\nUpload file path = " + uploadedFilePath
				+ "\nRaw data ID = " + rawDataId + "\n";
	}

}
