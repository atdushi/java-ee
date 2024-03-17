package com.virtualpairprogrammers.backingbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIData;
import javax.inject.Inject;
import javax.inject.Named;

import com.virtualpairprogrammers.staffmanagement.EmployeeManagementServiceLocal;
import com.virtualpairprogrammers.staffmanagement.domain.Employee;

/**
 * Пример аннотаций CDI вместо JSF
 *
 * @Named("allEmployeesPageBean") + @RequestScoped = @Model
 */
//@Named("allEmployeesPageBean")
//@RequestScoped
@Model
public class AllEmployeesPageBean {
    //    @Inject
//    private EmployeeManagementServiceLocal employeeService;
    private Employee selectedEmployee;
    private UIData dataTable;
    private UIData dataTableOld;

    // больше не нужен, т.к. CDI напрямую вызывает employeeManagementImplementation
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }

    public String showEmployee() {
        this.selectedEmployee = (Employee) dataTable.getRowData();

        return "employeeDetail";
    }

    public String showEmployeeOld() {
        this.selectedEmployee = (Employee) dataTableOld.getRowData();

        return "employeeDetail";
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public void setSelectedEmployee(Employee selectedEmployee) {
        this.selectedEmployee = selectedEmployee;
    }

    public UIData getDataTable() {
        return dataTable;
    }

    public void setDataTable(UIData dataTable) {
        this.dataTable = dataTable;
    }

    public UIData getDataTableOld() {
        return dataTableOld;
    }

    public void setDataTableOld(UIData dataTableOld) {
        this.dataTableOld = dataTableOld;
    }
}
