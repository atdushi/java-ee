package com.virtualpairprogrammers.staffmanagement.rest;

import com.virtualpairprogrammers.dataaccess.EmployeeNotFoundException;
import com.virtualpairprogrammers.staffmanagement.EmployeeManagementServiceLocal;
import com.virtualpairprogrammers.staffmanagement.SystemUnavailableException;
import com.virtualpairprogrammers.staffmanagement.domain.Employee;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * http://localhost:8080/EmployeeManagement/webservice/employees
 */
@Path("/employees")
//@Stateless -- вроде, не надо промоутить до EJB
public class EmployeeResource {
    @EJB
    private EmployeeManagementServiceLocal employeeManagement;

    @GET
    @Produces("application/xml")
    public List<Employee> getAllEmployees(){
        return employeeManagement.getAllEmployees();
    }

    @GET
    @Produces("application/xml")
    @Path("{id}")   // matches the URL of /employees/{id}
    public Employee findEmployeeById(@PathParam("id") int id){
        try
        {
            return employeeManagement.getEmployeeById(id);
        }
        catch (EmployeeNotFoundException e)
        {
            // return 404
            return null;
        }
    }

    @DELETE
    @Path("{id}")
    public Response deleteEmployeeById(@PathParam("id") int id)
    {
        try
        {
            employeeManagement.deleteEmployeeById(id);
            return Response.ok().build();
        }
        catch (EmployeeNotFoundException e)
        {
            return Response.status(404).build();
        }
    }

    @POST
    @Produces("application/xml")
    @Consumes("application/xml")
    public Response createNewEmployee(Employee employee){
        try {
            employeeManagement.registerEmployee(employee);
            return Response.ok().entity(employee).build();
        } catch (SystemUnavailableException e) {
            return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
        }
    }
}
