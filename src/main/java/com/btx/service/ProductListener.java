package com.btx.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

@Component("productListener")
public class ProductListener implements MessageListener{

	@Override
	public void onMessage(Message arg0) {
		// TODO Auto-generated method stub
		try {
			System.out.println("生产者接受到的应答："+((TextMessage)arg0).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
