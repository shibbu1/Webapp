package com.webapp.Webapp.controller;

import com.webapp.Webapp.model.Employee;
import com.webapp.Webapp.repository.EmployeeRepository;
import com.webapp.Webapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private EmployeeService service;


    @PostMapping("/save")
   public Employee saveEmployee(@RequestBody Employee emp){

       return service.saveEmployee(emp);
   }

   @GetMapping("/all")
   public List<Employee> getAllEmployee(){
        return service.getAllEmployee();
   }

   @GetMapping("/employee/{id}")
   public Employee findEmpById( @PathVariable("id") int empId ){
        return service.findEmpById(empId);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody Employee emp , @PathVariable("id") int empId){

        return service.updateEmployee(empId, emp);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int empId){
         service.deleteEmployee(empId);
        return "Employee deleted successfully!!";
    }
}
