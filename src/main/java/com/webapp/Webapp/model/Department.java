package com.webapp.Webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private int deptId;

    private String deptName;

    private String deptLocation;




    public Department() {
    }

   /* public Department(EmpDeptDTO req) {

        this.employee= req.getEmployee();
    }*/

    public Department(int deptId, String deptName, String deptLocation) {
        this.deptId = deptId;
        this.deptName = deptName;
        this.deptLocation = deptLocation;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getDeptLocation() {
        return deptLocation;
    }

    public void setDeptLocation(String deptLocation) {
        this.deptLocation = deptLocation;
    }

    @Override
    public String toString() {
        return "Department{" +
                "deptId=" + deptId +
                ", deptName='" + deptName + '\'' +
                ", deptLocation='" + deptLocation + '\'' +
                '}';
    }

}
