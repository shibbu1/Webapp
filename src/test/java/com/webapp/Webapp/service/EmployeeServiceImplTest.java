package com.webapp.Webapp.service;


import com.webapp.Webapp.model.Employee;
import com.webapp.Webapp.repository.EmployeeRepository;
import org.assertj.core.api.FactoryBasedNavigableListAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.webapp.Webapp.model.Employee.*;
import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//this annotations is used to store mock data in repo
@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {


   @Mock
    private EmployeeRepository repo;


    private Employee employee;
   @Autowired
    private EmployeeService service;

//   this annoattion used to run before any test cases
    @BeforeEach
    void setUp(){
        this.service=new EmployeeServiceImpl(this.repo);



    }



    @Test
    void saveEmployee() {
        Employee empTest= new Employee();

        empTest.setEmpId(12);
        empTest.setEmpName("Ankur");
        empTest.setEmpNum(23212);
        empTest.setEmpCity("Bhind");

        repo.save(empTest);
        Mockito.when(repo.save(empTest)).thenReturn(empTest);
        assertNotNull(service.saveEmployee(empTest));

    }

    @Test
    void getAllEmployee() {

     //when(repo.findAll()).thenReturn(Stream.of( new Employee(23,"Harsh",4534,"Gwalior")).collect(Collectors.toList()));

      // assertEquals(1,service.getAllEmployee().size());

        service.getAllEmployee();
        verify(repo).findAll();

    }

    @Test
    void findEmpById() {

        Employee empTest= new Employee(12,"sdfsd",3432,"fdsf");

             //  empTest.setEmpId(12);
             //  empTest.setEmpName("Ankur");
           //  empTest.setEmpNum(23212);
           //  empTest.setEmpCity("Bhind");

        repo.save(empTest);

        int actual = empTest.getEmpId();

        int expected =12;
        assertEquals(expected,actual);

    }

    @Test
    void updateEmployee() {
        Employee empTest= new Employee(12,"sdfsd",3432,"fdsf");
        repo.save(empTest);
        empTest.setEmpName("sssss");
        empTest.setEmpNum(342);
        empTest.setEmpCity("fwsf");
        Employee em= repo.save(empTest);
        assertNotEquals(em,empTest);



    }

    @Test
    void deleteEmployee() {

        Employee empTest= new Employee(12,"sdfsd",3432,"fdsf");
        repo.save(empTest);
        repo.deleteById(empTest.getEmpId());

        boolean id = repo.existsById(empTest.getEmpId());
        assertFalse(id);
    }
}