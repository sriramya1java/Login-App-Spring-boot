package com.javasampleapproach.jpamysqlangular4.repo;

import org.springframework.data.repository.CrudRepository;

import com.javasampleapproach.jpamysqlangular4.model.Registration;

public interface RegistrationRepository extends CrudRepository<Registration, Long> {



}
