package com.example.employee.repository;

import com.example.employee.entity.Company;
import com.example.employee.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByName(String name);

    Employee findFirstByNameContains(String name);

    List<Employee> findBySalaryBetween(int min, int max);

    Employee findFirstByIdOrderBySalaryDesc(int id);

    @Query("select u from Employee u where u.name like %?1%")
    Employee findByNameContains(String name);

    }
