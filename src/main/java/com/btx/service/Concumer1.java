package com.btx.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
@Service
public class Concumer1 implements MessageListener{

	@Autowired
	@Qualifier("product")
	private JmsTemplate jmsTemplate;
	@Override
	public void onMessage(Message arg0) {
		try {
			String msg = ((TextMessage)arg0).getText();
			System.out.println("Concumer1 :"+msg);
			jmsTemplate.send(arg0.getJMSReplyTo(), new MessageCreator() {
				
				@Override
				public Message createMessage(Session arg0) throws JMSException {
					
					return arg0.createTextMessage("Concumer1 向生产者发送消息");
				}
			});
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
