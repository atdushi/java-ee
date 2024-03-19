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
import javax.jms.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@Stateless
@WebService(name = "employeeManagementWebService")
@RolesAllowed("admin")
@Named("employeeManagementImplementation")  // для референса из CDI
public class EmployeeManagementImplementation
        implements EmployeeManagementServiceRemote, EmployeeManagementServiceLocal {

    // weld container - implementation of CDI
    @Inject
    @ProductionDao
    private EmployeeDataAccess dao;

    // Java EE >= 5 => DI container
//    @EJB
//    private ExternalPayrollSystem payrollSystem;

    @Resource
    private SessionContext glassfish;   // this object is often called ctx

    @Resource(mappedName = "jms/EmployeeManagementQueue")
    private Queue queue;

    @Resource(mappedName = "jms/ConnectionFactory")
    private ConnectionFactory connectionFactory;

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

        try
        {
            Connection connection = connectionFactory.createConnection();

            Session session = connection.createSession(false, 0);

            MessageProducer messageProducer = session.createProducer(queue);

            MapMessage message = session.createMapMessage();
            message.setString("employeeName", newEmployee.getFirstName() + " " + newEmployee.getSurname());
            message.setString("employeeJobRole", newEmployee.getJobRole());
            message.setInt("employeeSalary", newEmployee.getSalary());

            messageProducer.send(message);
            connection.close();
        }
        catch (JMSException e)
        {
            throw new SystemUnavailableException();
        }
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
