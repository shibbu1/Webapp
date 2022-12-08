package com.webapp.Webapp.service;

import com.webapp.Webapp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {



    Employee saveEmployee(Employee emp);

    List<Employee> getAllEmployee();

    Employee findEmpById(int empId);

    Employee updateEmployee(int empId, Employee emp);

     public void deleteEmployee(int empId);

    Optional<Employee> findByUsername(String username);


}
