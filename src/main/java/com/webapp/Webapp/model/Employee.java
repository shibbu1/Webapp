package com.webapp.Webapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int empId;
    private String empName;
    private long empNum;

    private String empCity;

    public Employee() {

    }

    public Employee(int empId, String empName, long empNum, String empCity) {
        this.empId = empId;
        this.empName = empName;
        this.empNum = empNum;
        this.empCity = empCity;
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
                '}';
    }


}
