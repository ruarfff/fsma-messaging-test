/**
 * This code is copyright (c) 2014 EMC Corporation
 */
package com.emc.psasss.tools.fsma.messaging.producer;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.emc.psasss.tools.fsma.messaging.model.DestinationEnums;

/**
 * Implementations of the {@link MessageSender} to queue messages as json
 */
@Component("jsonMessageSender")
public class JsonMessageSender implements MessageSender {

	/**
	 * List of available {@link Queue} to send messages to
	 */
	@Autowired
	private List<Queue> queues;

	/**
	 * Spring JmsTemplate used to send messages to the queue
	 */
	@Autowired
	private JmsTemplate jmsTemplate;

	@Override
	public void sendMessage(DestinationEnums destination, final Object message)
			throws JMSException {
		Queue queue = null;
		String destinationQueue = destination.toString();
		if (queues != null) {
			for (Queue search : queues) {
				if (destinationQueue.equals(search.getQueueName())) {
					queue = search;
					break;
				}
			}
		}

		if (queue != null) {
			jmsTemplate.send(queue, new JsonMessageCreator(message));
		} else {
			throw new RuntimeException("Cannot find queue for destination "
					+ destinationQueue);
		}
	}

	/**
	 * @param jmsTemplate
	 *            the jmsTemplate to set
	 */
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	/**
	 * @param queues
	 *            the queues to set
	 */
	public void setQueues(List<Queue> queues) {
		this.queues = queues;
	}
}
