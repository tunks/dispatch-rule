/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.att.dispatch.rule.model;

import com.att.dispatch.rule.process.IMessage;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ebrima
 * Message class to send or publish messages 
 */
public class Message implements Serializable, IMessage{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<Map> messages; 
    
    public Message() {
      messages = new ArrayList<Map>();
    }

    public List<Map> getMessages() {
        return messages;
    }
    //add message
    public void add(String channel, String message) {
        Map<String,String> msg = new HashMap<String, String>();
        msg.put(channel, message);
        messages.add(msg);
    }
    //
    public String toString(){
    	StringBuilder builder =  new StringBuilder();
    	for(Map<String,String> message : messages){
    		Iterator<String> itr = message.values().iterator();
    		while(itr.hasNext()){
    			builder.append(itr.next());
    		}
    	}
    	return  builder.toString();
    }
}
