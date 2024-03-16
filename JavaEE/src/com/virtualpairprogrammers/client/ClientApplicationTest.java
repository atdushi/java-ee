package com.virtualpairprogrammers.client;

import com.sun.enterprise.security.ee.auth.login.ProgrammaticLogin;
import com.virtualpairprogrammers.dataaccess.EmployeeNotFoundException;
import com.virtualpairprogrammers.staffmanagement.EmployeeManagementServiceRemote;
import com.virtualpairprogrammers.staffmanagement.SystemUnavailableException;
import com.virtualpairprogrammers.staffmanagement.domain.Employee;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.List;

public class ClientApplicationTest {
    public static void main(String[] args) {
        try {
            ProgrammaticLogin pl = new ProgrammaticLogin();
            pl.login("admin", "admin");

            Context jndi = new InitialContext();

            // Java EE >= 6 => java:global/<module-name>/<bean-name>
            EmployeeManagementServiceRemote service = (EmployeeManagementServiceRemote)
                    jndi.lookup("java:global/EmployeeManagement/EmployeeManagementImplementation!com.virtualpairprogrammers.staffmanagement.EmployeeManagementServiceRemote");

            Employee employee = service.getEmployeeById(301);
            System.out.println(employee);

            List<Employee> employees = service.getAllEmployees();

            for (Employee next : employees) {
                System.out.println(next);
            }

//            try
//            {
//                service.registerEmployee(new Employee("Ronald","Parsons","Broadcaster",40000));
//            }
//            catch (SystemUnavailableException e)
//            {
//                System.out.println("Sorry, the payroll system is unavailable. try again later");
//            }

        } catch (NamingException e) {
            System.out.println(e);
        } catch (EmployeeNotFoundException e) {
            System.out.println(e);
        }
    }
}
