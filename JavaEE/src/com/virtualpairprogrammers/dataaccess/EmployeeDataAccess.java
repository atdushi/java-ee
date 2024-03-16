package com.virtualpairprogrammers.dataaccess;

import com.virtualpairprogrammers.staffmanagement.domain.Employee;

import java.util.List;

public interface EmployeeDataAccess {
    List<Employee> findAll();

    List<Employee> findBySurname(String surname);

    void insert(Employee newEmployee);

    Employee findById(int id) throws EmployeeNotFoundException;

    void deleteById(int id) throws EmployeeNotFoundException;
}
