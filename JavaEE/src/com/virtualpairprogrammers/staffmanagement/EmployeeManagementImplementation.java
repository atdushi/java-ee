package com.virtualpairprogrammers.staffmanagement;

import com.virtualpairprogrammers.dataaccess.EmployeeDataAccess;
import com.virtualpairprogrammers.dataaccess.EmployeeDataAccessImplementation;
import com.virtualpairprogrammers.dataaccess.EmployeeNotFoundException;
import com.virtualpairprogrammers.dataaccess.ProductionDao;
import com.virtualpairprogrammers.staffmanagement.domain.Employee;

import javax.annotation.Resource;
import javax.annotation.security.RolesAllowed;
import javax.ejb.*;
import javax.inject.Inject;
import javax.inject.Named;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(name = "employeeManagementWebService")
@RolesAllowed("admin")
@Named("employeeManagementImplementation")  // для референса из CDI
public class EmployeeManagementImplementation
        implements EmployeeManagementServiceRemote, EmployeeManagementServiceLocal {

    // Java EE >= 5 => DI container
    @Inject
    @ProductionDao
    private EmployeeDataAccess dao;

    @EJB
    private ExternalPayrollSystem payrollSystem;

    @Resource
    private SessionContext glassfish;   // this object is often called ctx

    @Override
//    @RolesAllowed("users")
    public List<Employee> getAllEmployees() {
        return dao.findAll();
    }

//    @Override
//    public void registerEmployee(Employee newEmployee) throws SystemUnavailableException {
//        dao.insert(newEmployee);
//        try {
//            payrollSystem.enrollEmployee(newEmployee);
//        } catch (SystemUnavailableException e) {
//            glassfish.setRollbackOnly();
//            throw e;
//        }
//    }

    @Override
//    @RolesAllowed("admin")
    public void registerEmployee(Employee newEmployee) throws SystemUnavailableException {
        dao.insert(newEmployee);
        payrollSystem.enrollEmployee(newEmployee);
    }

    @Override
    public List<Employee> searchBySurname(String surname) {
        return dao.findBySurname(surname);
    }

    @Override
    public Employee getEmployeeById(int id) throws EmployeeNotFoundException {
        return dao.findById(id);
    }

    @Override
    public void deleteEmployeeById(int id) throws EmployeeNotFoundException {
        dao.deleteById(id);
    }

    // a transaction is not needed
    @TransactionAttribute(TransactionAttributeType.SUPPORTS)
    @WebMethod(exclude = true) // не надо в WSDL
    public void calc() {
        // in memory
    }
}
