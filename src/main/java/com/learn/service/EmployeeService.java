package com.learn.service;

import java.util.List;

import com.learn.entity.Employee;

public interface EmployeeService {
    List<Employee> findAll();

    void insertEmployee(Employee emp);

    void updateEmployee(Employee emp);

    void deleteEmployee(Integer id);

}
