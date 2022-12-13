package com.webapp.Webapp.model;


import javax.persistence.*;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="deptId")
    private Department department;



    public Employee() {

    }







    public Employee(int empId, String empName, long empNum, String empCity, String username, String password, Department department) {
        this.empId = empId;
        this.empName = empName;
        this.empNum = empNum;
        this.empCity = empCity;
        this.username = username;
        this.password = password;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empNum=" + empNum +
                ", empCity='" + empCity + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", department=" + department +
                '}';
    }
}

