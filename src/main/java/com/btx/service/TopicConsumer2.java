package com.btx.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Service;

@Service
public class TopicConsumer2 implements MessageListener{

	@Override
	public void onMessage(Message arg0) {
		try {
			String msg = ((TextMessage)arg0).getText();
			System.out.println("TopicConsumer2 :"+msg);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}