package com.springboot.crudrestfulwebservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.crudrestfulwebservices.model.Employee;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}

