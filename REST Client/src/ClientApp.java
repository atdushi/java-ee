import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

public class ClientApp {
    public static void main(String[] args) {
        // Authentication
        Client client = ClientBuilder.newClient();
        client.register(HttpAuthenticationFeature.basic("admin", "admin"));

        // GET
        WebTarget webTarget = client.target("http://localhost:8080/EmployeeManagement/webservice/employees/301");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        Employee employee = invocationBuilder.get(Employee.class);
        System.out.println(employee.getFirstName() + " " + employee.getSurname());

        // GET all
        webTarget = client.target("http://localhost:8080/EmployeeManagement/webservice/employees");
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        List<Employee> allEmployees = invocationBuilder.get(new GenericType<List<Employee>>() {
        });
        for (Employee next : allEmployees) {
            System.out.println(next.getJobRole());
        }

        // POST
        Employee newEmployee = new Employee();
        newEmployee.setFirstName("James");
        newEmployee.setSurname("Gosling");
        newEmployee.setJobRole("Creator of Java");
        newEmployee.setSalary(1000000);

        Response response = invocationBuilder.post(Entity.entity(newEmployee, MediaType.APPLICATION_XML));

        System.out.println("The response code was " + response.getStatus());

        Employee gosling = new Employee();
        if (response.getStatus() == 200) {
            gosling = response.readEntity(Employee.class);
            System.out.println(gosling.getSurname());
        }

        // DELETE
        webTarget = client.target("http://localhost:8080/EmployeeManagement/webservice/employees/" + gosling.getId());
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        if (response.getStatus() == 404) {
            System.out.println("Sorry, that employee resource didn't exist");
        } else {
            System.out.println("Gosling deleted");
        }
    }
}
