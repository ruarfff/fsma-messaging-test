/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.model;

import junit.framework.TestCase;

import org.junit.Test;

/**
 * Unit tests for the DestinationEnums class
 */
public class DestinationEnumsTest {
    @Test
    public void testQueueNameRemediation() {
	TestCase.assertEquals("emc.psasss.fsma.report", DestinationEnums.FSMA_WORD_REPORT.toString());
    }
}
