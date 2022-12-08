package com.webapp.Webapp.service;

import com.webapp.Webapp.model.Employee;
import com.webapp.Webapp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {




    @Autowired
    private EmployeeRepository repo;

    @Autowired

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

//    @Autowired
//    private BCryptPasswordEncoder pwdEncoder;

    @Override
    public Employee saveEmployee(Employee emp) {

        // use for security and get the password
        /*emp.setPassword(
               pwdEncoder.encode(emp.getPassword())
        );*/

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


    ////////////////////////////////////////////////////



   public Optional<Employee> findByUsername(String username){
        return repo.findByUsername(username);
   }

   /* @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Optional<Employee> opt= findByUsername(s);

        if(opt.isEmpty())
            throw new UsernameNotFoundException("User not found");

        Employee employee=opt.get();

        return new org.springframework.security.core.userdetails.User(
               employee.getUsername(),
                employee.getPassword(),
                employee.getEmpName(),(role->new SimpleGrantedAuthority(employee.getEmpName())))
                        .collect(Collectors.toList());





        );*/


    }


