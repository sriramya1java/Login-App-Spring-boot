/*package com.javasampleapproach.jpasqlangular4.service;

import java.util.*;

import com.javasampleapproach.jpamysqlangular4.model.Configuration;
import com.javasampleapproach.jpamysqlangular4.repo.ConfigurationRepository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

*//**
 * Created by sdeevi on 1/23/2018.
 *//*

@Service
public class ConfigurationService {

	private static Logger logger = LoggerFactory.getLogger(ConfigurationService.class);

	@Autowired
	ConfigurationRepository IConfigRep;

	public synchronized boolean submitSchedule(String scheduleObject) throws Exception {

		logger.info("ScheduleService: submitSchedule...");
		logger.info("ScheduleService: aiedecObject=" + scheduleObject);

		JSONObject obj = new JSONObject(scheduleObject);
		logger.info("ScheduleService: Set ConfigurationDTO values...");
		Configuration scheduleDTO = new Configuration();
		Map<String, String> map = new HashMap<>();
		logger.debug("BatchStart :" + obj.getString("batchStart"));
		logger.debug("BatchEnd :" + obj.getString("batchEnd"));

		map.put("BatchStart", obj.getString("batchStart"));
		map.put("BatchEnd", obj.getString("batchEnd"));

		String currentDate = getCurrentDate();
		try {
			for (String key : map.keySet()) {
				String value = map.get(key);
				scheduleDTO.setConfigKey(key);
				scheduleDTO.setConfigValue(value);

				// scheduleDTO.setAc_date_last ( currentDate);
				IConfigRep.submitSchedule(scheduleDTO);
			}
		} catch (Exception e) {
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
		return String.format("%s%s%s", year, month > 9 ? month : "0" + month, day > 9 ? day : "0" + day);
	}

}
*/