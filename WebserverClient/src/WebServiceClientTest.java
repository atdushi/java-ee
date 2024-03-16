import com.virtualpairprogrammers.staffmanagement.*;

import javax.xml.ws.BindingProvider;
import java.util.List;

/**
 * http://localhost:8080/EmployeeManagementImplementationService/employeeManagementWebService?wsdl
 * http://localhost:8080/EmployeeManagementImplementationService/employeeManagementWebService?Tester
 *
 * wsimport.exe -s .\src\ -d .\bin\ -keep -verbose http://localhost:8080/EmployeeManagementImplementationService/employeeManagementWebService?wsdl
 */
public class WebServiceClientTest {
    public static void main(String[] args) {
        EmployeeManagementWebService service =
                new EmployeeManagementImplementationService().getEmployeeManagementWebServicePort();

//        ((BindingProvider)service).getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "admin");
//        ((BindingProvider)service).getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, "admin");

        List<Employee> allEmployees = service.getAllEmployees();
        for (Employee next : allEmployees) {
            System.out.println(next.getFirstName() + " " + next.getSurname());
        }

        Employee newEmployee = new Employee();
        newEmployee.setFirstName("Bill");
        newEmployee.setSurname("Maynard");
        newEmployee.setJobRole("Actor");
        newEmployee.setSalary(17999);

        try
        {
            service.registerEmployee(newEmployee);
        }
        catch (SystemUnavailableException_Exception e)
        {
            System.out.println("Payroll System Unavailable");
        }
    }
}
