package com.virtualpairprogrammers.dataaccess;

import com.virtualpairprogrammers.staffmanagement.domain.Employee;

import java.util.List;

@TestingDao
public class EmployeeDataAccessTestingVersion implements EmployeeDataAccess{
    @Override
    public List<Employee> findAll() {
        return null;
    }

    @Override
    public List<Employee> findBySurname(String surname) {
        return null;
    }

    @Override
    public void insert(Employee newEmployee) {

    }

    @Override
    public Employee findById(int id) throws EmployeeNotFoundException {
        return null;
    }

    @Override
    public void deleteById(int id) throws EmployeeNotFoundException {

    }
}
