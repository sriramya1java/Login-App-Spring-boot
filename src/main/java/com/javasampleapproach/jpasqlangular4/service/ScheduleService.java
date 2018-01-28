package com.javasampleapproach.jpasqlangular4.service;
import com.javasampleapproach.jpamysqlangular4.dto.ConfigurationDTO;
import com.javasampleapproach.jpamysqlangular4.repo.ConfigurationRepository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class ScheduleService {

        @Autowired
        ConfigurationRepository FmsDAO;

        private static Logger logger = LoggerFactory.getLogger ( ScheduleService.class );
            public String getCurrentDate() {
                GregorianCalendar greg = new GregorianCalendar();
                Integer month = greg.get(GregorianCalendar.MONTH) + 1;
                Integer day = greg.get(GregorianCalendar.DAY_OF_MONTH);
                Integer year = greg.get(GregorianCalendar.YEAR);
                return String.format("%s%s%s", year, month > 9 ? month : "0" + month, day > 9 ? day : "0" + day );
            }

        public synchronized boolean submitSchedule(String scheduleObject) throws Exception {

                logger.info ( "ScheduleService: submitSchedule..." );
                logger.info ( "ScheduleService: aiedecObject=" + scheduleObject );

                JSONObject obj = new JSONObject( scheduleObject );
                logger.info ( "ScheduleService: Set ConfigurationDTO values..." );
                ConfigurationDTO scheduleDTO = new ConfigurationDTO ( );
                Map<String, String> map = new HashMap<>( );
                logger.debug ( "BatchStart is :"+ obj.getString ( "batchStart" ) );
                logger.debug ( "BatchEnd is :"+ obj.getString ( "batchEnd" ) );

                map.put ( "AIEStartDate", obj.getString ( "batchStart" ) );
                map.put ( "AIEEndDate", obj.getString ( "batchEnd" ) );

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

	
}
