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
@Table(name = "registration")

public class Registration implements Serializable {

	private static Logger logger = LoggerFactory.getLogger(Customer.class);

	private static final long serialVersionUID = -3009157732242241606L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long userid;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "birthday")
	private String birthday;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "phone")
	private String phone;
	
	@Column(name="email")
	private String email;
	
	
	@Column(name="createdate")
	private String createdate;

	public String getCreatedate() {
		return createdate;
	}



	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}



	public Registration() {
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getBirthday() {
		return birthday;
	}



	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	


	/*public Registration(String firstName, String lastName, String userName, String password,String birthday,
			String email, String gender, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.birthday = birthday;
		this.email = email;
		this.gender = gender;
		this.phone = phone;
	}*/
	
	public Registration(String firstName, String lastName, String userName, String password, String birthday,
			String gender, String phone, String email, String createdate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.createdate = createdate;
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






	
	