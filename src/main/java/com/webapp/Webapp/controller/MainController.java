package com.webapp.Webapp.controller;

import com.webapp.Webapp.model.Employee;
import com.webapp.Webapp.model.UserRequest;
import com.webapp.Webapp.model.UserResponse;
import com.webapp.Webapp.service.EmployeeService;
import com.webapp.Webapp.service.UserService;
import com.webapp.Webapp.utility.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService service;

    @Autowired
    private JwtUtil util;

    @Autowired
    private AuthenticationManager authenticationManager;




   /* @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee emp) {

        return service.saveEmployee(emp);
    }*/

    @GetMapping("/all")
    public List<Employee> getAllEmployee() {
        return service.getAllEmployee();
    }

    @GetMapping("/employee/{id}")
    public Employee findEmpById(@PathVariable("id") int empId) {
        return service.findEmpById(empId);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody Employee emp, @PathVariable("id") int empId) {

        return service.updateEmployee(empId, emp);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int empId) {
        service.deleteEmployee(empId);
        return "Employee deleted successfully!!";
    }


    ////////////////////////////////////////////////////////////////////////

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to my page";
    }

    @PostMapping("/authenticate")
    public UserResponse authenticate(@RequestBody UserRequest userRequest) throws Exception{

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            userRequest.getUsername(),
                            userRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(userRequest.getUsername());

        final String token =
                util.generateToken(userDetails);

        return  new UserResponse(token);
    }
}
