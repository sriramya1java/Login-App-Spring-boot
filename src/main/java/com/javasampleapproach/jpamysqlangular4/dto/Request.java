package com.javasampleapproach.jpamysqlangular4.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javasampleapproach.jpamysqlangular4.model.Customer;

public class Request {
	private static Logger logger = LoggerFactory.getLogger(Customer.class);
	public String userName;
	public String pwd;

	public String getUserName() {
		return userName;
	}
    
	public String getPwd(){
		return pwd;
	}
	
	public String toStringReturn() {
    	ObjectMapper mapper = new ObjectMapper();
    	String stringToReturn = null; //Return null by default
    	try {
    		stringToReturn=mapper.writeValueAsString(this);
    	}catch(Exception e) {
    		logger.error("Error converting ScheduleDTO object to json string");
    	}
    	//return json representation of the object
    	return stringToReturn;
    }
}
