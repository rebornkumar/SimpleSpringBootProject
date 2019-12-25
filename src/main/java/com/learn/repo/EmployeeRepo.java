package com.learn.repo;

import com.learn.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    @Modifying
    @Transactional
    @Query(value = "insert into employee(id,address,email,name) values (?1, ?4, ?3, ?2)",nativeQuery = true)
    void insertEmp(Integer employeeId,String employeeName,String employeeEmail,String employeeAddress);

    @Modifying
    @Transactional
    @Query(value = "update employee SET name = ?2, email = ?3, address = ?4 where id = ?1",nativeQuery = true)
    void updateEmp(Integer employeeId,String employeeName,String employeeEmail,String employeeAddress);
}
