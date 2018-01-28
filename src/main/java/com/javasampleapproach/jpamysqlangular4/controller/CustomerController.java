package com.javasampleapproach.jpamysqlangular4.controller;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.javasampleapproach.jpamysqlangular4.dto.ConfigurationDTO;
import com.javasampleapproach.jpamysqlangular4.dto.GenerateBatch;
import com.javasampleapproach.jpamysqlangular4.dto.Request;
import com.javasampleapproach.jpamysqlangular4.dto.ScheduleDTO;
import com.javasampleapproach.jpamysqlangular4.model.Configuration;
import com.javasampleapproach.jpamysqlangular4.model.Customer;
import com.javasampleapproach.jpamysqlangular4.model.Registration;
import com.javasampleapproach.jpamysqlangular4.repo.ConfigurationRepository;
import com.javasampleapproach.jpamysqlangular4.repo.CustomerRepository;
import com.javasampleapproach.jpamysqlangular4.repo.RegistrationRepository;
import com.javasampleapproach.jpasqlangular4.service.ScheduleService;

@RestController
public class CustomerController {

	 private static Logger logger = LoggerFactory.getLogger(CustomerController.class);
	 Map<String, String> map = new HashMap<String, String>();
	 
	@Autowired
	CustomerRepository repository;
	
	@Autowired
	RegistrationRepository repositoryReg;

	@Autowired
    ConfigurationRepository FmsDAO;

	@GetMapping(value="/customer",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> getAll() {
		List<Customer> list = new ArrayList<>();
		Iterable<Customer> customers = repository.findAll();

		customers.forEach(list::add);
		return list;
	}
	
	@PostMapping(value="/postcustomer")
	public Customer postCustomer(@RequestBody Customer customer) {

		logger.debug ( "CustomereObject "  + customer.toString());
		
		repository.save(new Customer(customer.getFirstName(), customer.getLastName(), customer.getUserName(),customer.getPwd(),
				customer.getEmail(), customer.getGender(), customer.getFavouriteColor()));
		return customer;
	}	
	
	
	@PostMapping(value = "/createschedule")
    public synchronized boolean createSchedule(@RequestBody ScheduleDTO scheduleObject) throws Exception {

        logger.debug ( "scheduleObject "  + scheduleObject.toString ());
      
        ConfigurationDTO scheduleDTO = new ConfigurationDTO ( );
        Map<String, String> map = new HashMap<>( );
        logger.debug ( "BatchStart is :"+ scheduleObject.getBatchStart());
        logger.debug ( "BatchEnd is :"+ scheduleObject.getBatchEnd() );
        logger.debug("Current Date is "+ scheduleObject.getCurrentDate());
        logger.debug("Current Time is "+ scheduleObject.getCurrentTime());

        map.put ( "AIEStartDate", scheduleObject.getBatchStart());
        map.put ( "AIEEndDate", scheduleObject.getBatchEnd() );
        map.put ( "AIECurrentDate", scheduleObject.getCurrentDate());
        map.put ( "AIECurrentTime", scheduleObject.getCurrentTime());
        try {
            for (String key : map.keySet ( )) {
                    String value = map.get ( key );
                    scheduleDTO.setAc_key ( key );
                    scheduleDTO.setAc_value ( value );
           
                    FmsDAO.submitSchedule ( scheduleDTO );
            }
    }catch(Exception e) {
            String error = "Failed to save, please check the value you entered is correct.";
            logger.info(error);
            return false;

    }
    return true;
    }
	
	
	public String getCurrentDate() {
        GregorianCalendar greg = new GregorianCalendar();
        Integer month = greg.get(GregorianCalendar.MONTH) + 1;
        Integer day = greg.get(GregorianCalendar.DAY_OF_MONTH);
        Integer year = greg.get(GregorianCalendar.YEAR);
        return String.format("%s%s%s", year, month > 9 ? month : "0" + month, day > 9 ? day : "0" + day );
    }
	
	@PostMapping(value="/postregister")
	public boolean postRegister(@RequestBody Registration register) {
		logger.debug("Registration Object" +register.toStringReturn());
		logger.debug(register.getEmail());
		logger.debug(register.getGender());
		logger.debug(register.getPhone());
		logger.debug("Before :" + register.getCreatedate());
		
		String createDate = getCurrentDate();
		
		register.setCreatedate(createDate);
		
		logger.debug("Afrer :" + register.getCreatedate());
		
		repositoryReg.save(new Registration(register.getFirstName(), register.getLastName(), register.getUserName(), 
				register.getPassword(), register.getBirthday(),	register.getGender(), register.getPhone(), register.getEmail(),register.getCreatedate()));
		
		return true;
	}
	
	
	
	@PostMapping(value="/logincustomer")
	public Boolean loginCustomer(@RequestBody Request request) {
		logger.debug ( "CustomereObject "  + request.toStringReturn());
		Customer customer = repository.findByUserName(request.getUserName());
		if(customer != null){
			if(request.getUserName().equals(customer.getUserName()) && request.getPwd().equals(customer.getPwd())){
	            System.out.println("yes true : ");
	            return true;
	        }
		}
		
		return false;

		
	}

	@GetMapping(value="/findbylastname/{lastName}",  produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Customer> findByLastName(@PathVariable String lastName) {

		List<Customer> customers = repository.findByLastName(lastName);
		return customers;
	}
	
	
	@DeleteMapping(value="/customer/{id}")
	public void deleteCustomer(@PathVariable long id){
		
		repository.delete(id);
	}
}
