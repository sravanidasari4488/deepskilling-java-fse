package com.cognizant.handson4.springdata;

import com.cognizant.handson4.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
