package com.aniketsenvasy.sessionerppos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aniketsenvasy.sessionerppos.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
	
}
