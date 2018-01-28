package com.javasampleapproach.jpamysqlangular4.repo;

import com.javasampleapproach.jpamysqlangular4.dto.ConfigurationDTO;
import com.javasampleapproach.jpamysqlangular4.model.Configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.repository.CrudRepository;

@ComponentScan
public interface ConfigurationRepository {

    public boolean submitSchedule (ConfigurationDTO scheduleDTO);
}
