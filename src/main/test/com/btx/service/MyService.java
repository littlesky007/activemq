package com.btx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Service
public class MyService {
    @Autowired
    @Qualifier("product")
    private JmsTemplate product;

    @Autowired
    @Qualifier("topic")
    private JmsTemplate topic;

    public void send(String queueName,final String msg)
    {
        product.send(queueName, new MessageCreator() {
            @java.lang.Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }

    public void sendtopic(String queueName,final String msg)
    {
        topic.send(queueName, new MessageCreator() {
            @java.lang.Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(msg);
            }
        });
    }
    
    public String getMes(String queueName) throws JMSException
    {
    	TextMessage  message = (TextMessage) product.receive(queueName);
    	return message.getText();
    }
}
