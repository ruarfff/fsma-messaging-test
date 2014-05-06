/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.producer;

import javax.jms.JMSException;

import com.emc.psasss.tools.fsma.messaging.model.DestinationEnums;

/**
 * Interface to send a message to the queue
 */
public interface MessageSender {

    /**
     * Send a message with the passed object as the body to the destination queue passed
     * @param destination queue to send the message to
     * @param message object to serialize for the message body
     */
    void sendMessage(DestinationEnums destination, Object message) throws JMSException;
}
