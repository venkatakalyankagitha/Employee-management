package com.Student.Management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Student.Management.Model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
