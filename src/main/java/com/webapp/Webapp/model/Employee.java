package com.webapp.Webapp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;
    private String empName;
    private long empNum;

    private String empCity;

    private String username;

    private String password;

    public Employee() {

    }



    public Employee(int empId, String empName, long empNum, String empCity,String username, String password) {
        this.empId = empId;
        this.empName = empName;
        this.empNum = empNum;
        this.empCity = empCity;
        this.username = username;
        this.password = password;
    }


    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getEmpNum() {
        return empNum;
    }

    public void setEmpNum(long empNum) {
        this.empNum = empNum;
    }

    public String getEmpCity() {
        return empCity;
    }

    public void setEmpCity(String empCity) {
        this.empCity = empCity;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empNum=" + empNum +
                ", empCity='" + empCity + '\'' +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    }

