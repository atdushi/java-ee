package com.virtualpairprogrammers.staffmanagement;

import com.virtualpairprogrammers.dataaccess.EmployeeNotFoundException;
import com.virtualpairprogrammers.staffmanagement.domain.Employee;

import javax.ejb.Local;
import java.util.List;

@Local
public interface EmployeeManagementServiceLocal
{
    void registerEmployee(Employee newEmployee) throws SystemUnavailableException ;

    List<Employee> getAllEmployees();

    List<Employee> searchBySurname(String surname);

    Employee getEmployeeById(int id) throws EmployeeNotFoundException;

    void deleteEmployeeById(int id) throws  EmployeeNotFoundException;
}
