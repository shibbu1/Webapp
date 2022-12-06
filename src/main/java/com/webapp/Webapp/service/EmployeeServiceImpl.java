package com.webapp.Webapp.service;

import com.webapp.Webapp.model.Employee;
import com.webapp.Webapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository repo;



    @Override
    public Employee saveEmployee(Employee emp) {
        return repo.save(emp);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return repo.findAll();
    }

    @Override
    public Employee findEmpById(int empId) {
        return repo.findById(empId).get();
    }

    @Override
    public Employee updateEmployee(int empId, Employee emp) {
        Employee employee = repo.findById(empId).get();

        employee.setEmpName(emp.getEmpName());
        employee.setEmpCity(emp.getEmpCity());
        employee.setEmpNum(emp.getEmpNum());

        return repo.save(employee);
    }


    @Override
    public void deleteEmployee(int empId) {
        repo.deleteById(empId);
    }
}
