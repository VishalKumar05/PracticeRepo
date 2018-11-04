package com.example.user.jsonparsing;

public class Employee {

    private String name;
    private String designation;
    private String dob;
    private String email;
    private String salary;
    private String mobNo;

    public Employee(String name,String designation,String dob,String email,String salary,String mobNo)
    {
        this.name = name;
        this.designation = designation;
        this.dob = dob;
        this.email = email;
        this.salary = salary;
        this.mobNo = mobNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getMobNo() {
        return mobNo;
    }

    public void setMobNo(String mobNo) {
        this.mobNo = mobNo;
    }
}
