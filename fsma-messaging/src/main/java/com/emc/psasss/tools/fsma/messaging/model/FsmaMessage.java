/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.model;

import java.io.Serializable;

public abstract class FsmaMessage implements Serializable {

	private static final long serialVersionUID = 5080443696795895128L;

	protected String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "FSMAMessage: \nName = " + name;
	}

}
