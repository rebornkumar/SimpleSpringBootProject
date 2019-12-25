package com.learn.serviceImpl;


import java.util.List;
import com.learn.entity.Employee;
import com.learn.repo.EmployeeRepo;
import com.learn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public List<Employee> findAll() {
        return  employeeRepo.findAll();
    }

    @Override
    public void insertEmployee(Employee emp) {
        employeeRepo.insertEmp(emp.getEmployeeId(),emp.getEmployeeName(),emp.getEmployeeEmail(),emp.getEmployeeAddress());
    }

    @Override
    public void updateEmployee(Employee emp) {
        employeeRepo.updateEmp(emp.getEmployeeId(),emp.getEmployeeName(),emp.getEmployeeEmail(),emp.getEmployeeAddress());
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepo.deleteById(id);
    }
}
