package com.btx.controller;

import com.btx.service.MyService;

import javax.jms.JMSException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/my")
public class MyController {
    @Autowired
    private MyService myService;

    @RequestMapping("/send")
    public String send(@RequestParam("msg") String msg)
    {
        String queueName = "test-queue";
        myService.send(queueName,msg);
        return  "successs";
    }
    
    @RequestMapping("/get")
    public @ResponseBody String get() throws JMSException
    {
    	return myService.getMes("test-queue");
    }

    @RequestMapping("/sendTopic")
    public @ResponseBody String sendTopic(String msg)
    {
        String topicName = "test-topic";
        myService.sendtopic(topicName,msg);
        return "success";
    }
}
