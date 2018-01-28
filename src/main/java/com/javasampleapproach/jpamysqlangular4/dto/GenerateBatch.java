package com.javasampleapproach.jpamysqlangular4.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javasampleapproach.jpamysqlangular4.model.Customer;

public class GenerateBatch {
	private static Logger logger = LoggerFactory.getLogger(Customer.class);
	public String batchStart;
	public String batchEnd;
	
	public String getBatchStart() {
		return batchStart;
	}


	public void setBatchStart(String batchStart) {
		this.batchStart = batchStart;
	}


	public String getBatchEnd() {
		return batchEnd;
	}


	public void setBatchEnd(String batchEnd) {
		this.batchEnd = batchEnd;
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
