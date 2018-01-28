package com.javasampleapproach.jpamysqlangular4.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;


@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	
	private static Logger logger = LoggerFactory.getLogger(Customer.class);

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "pwd")
	private String pwd;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "favouritecolor")
	private String favouriteColor;

	public Customer() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getFavouriteColor() {
		return favouriteColor;
	}

	public void setFavouriteColor(String favouriteColor) {
		this.favouriteColor = favouriteColor;
	}

	public Customer(String firstName, String lastName, String userName, String pwd, String email, String gender, String favouriteColor) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.pwd = pwd;
		this.email = email;
		this.gender = gender;
		this.favouriteColor = favouriteColor;
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