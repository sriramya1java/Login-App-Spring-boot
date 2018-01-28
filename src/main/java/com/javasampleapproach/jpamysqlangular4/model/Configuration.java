package com.javasampleapproach.jpamysqlangular4.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@Entity
@IdClass(ConfigurationCompositePK.class)
@Table(name = "configuration")

public class Configuration implements Serializable{
	private static Logger logger = LoggerFactory.getLogger(Configuration.class);

	private static final long serialVersionUID = -3009157732242241606L;

	@Id
	@Column(name = "configKey")
	private String configKey;
	
	@Column(name = "configValue")
	private String configValue;

	
	public String getConfigKey() {
		return configKey;
	}

	public void setConfigKey(String configKey) {
		this.configKey = configKey;
	}

	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}

	public Configuration(String configKey, String configValue) {
		super();
		this.configKey = configKey;
		this.configValue = configValue;
	}

	public Configuration() {
		// TODO Auto-generated constructor stub
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
