package com.javasampleapproach.jpamysqlangular4.repo;
import com.javasampleapproach.jpamysqlangular4.dto.ConfigurationDTO;
import com.javasampleapproach.jpamysqlangular4.model.Configuration;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.slf4j.Logger;

@Primary
@Transactional
@Repository
public class ConfigRepository implements ConfigurationRepository {

    @PersistenceContext
    @Autowired
    private EntityManager entityManager;
    private static Logger logger = LoggerFactory.getLogger(ConfigRepository.class);

    @Override
    public boolean submitSchedule(ConfigurationDTO scheduleDTO) {
        logger.debug("In ConfigRepository submitSchedule(scheduleDTO) DAO");

        entityManager.merge(scheduleDTO);
        return true;
    }
}