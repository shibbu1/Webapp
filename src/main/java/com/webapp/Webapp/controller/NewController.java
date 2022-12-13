package com.webapp.Webapp.controller;

import com.webapp.Webapp.model.Employee;
import com.webapp.Webapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewController {

    @Autowired
    private EmployeeRepository empRepo;

  /*  @Autowired
    private DepartmentRepository deptRepo;

    private Employee employee;*/


    @PostMapping("/saveWithDept")
    public Employee getEmpWithDept(@RequestBody Employee emp){


        /*Department d= new Department();
         d= empDeptDTO.getDepartment();
        Department dept= new Department();
        dept= deptRepo.save(d);
        Employee emp = new Employee();
        emp.setDepartment(dept);
        return empRepo.save(emp);*/

        /*empDeptDTO.setEmployee(empDeptDTO.getEmployee());
        empDeptDTO.setDepartment(empDeptDTO.getDepartment());
    Employee emp =empDeptDTO.getEmployee();
*/
        return empRepo.save(emp);











    }

    /*@GetMapping("findAllWithDept")
    public List<Employee> findAllEmpWithDept(){
        return empRepo.findAll();
    }*/
}
