package com.javasampleapproach.jpamysqlangular4.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;

/**
 * @author Sasi Kesani
 */
public class ScheduleDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Logger logger = LoggerFactory.getLogger(ScheduleDTO.class);

    private String batchStart = "";
    private String batchEnd = "";
    private String currentDate = "";
    private String currentTime = "";
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
	public String getCurrentDate() {
		return currentDate;
	}
	public void setCurrentDate(String currentDate) {
		this.currentDate = currentDate;
	}
	public String getCurrentTime() {
		return currentTime;
	}
	public void setCurrentTime(String currentTime) {
		this.currentTime = currentTime;
	}
    

   
}
