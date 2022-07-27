package com.example.demo2.Entity;

public class Employee {

    private String name;
    private int age;
    private String gender;
    private int id;
    private int salary;

    public Employee(int id, String name, String gender, int age, int salary) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Employee update(Employee updateEmployee) {
        this.salary = updateEmployee.getSalary();
        return this;
    }
}
