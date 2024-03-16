package com.virtualpairprogrammers.backingbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIData;

import com.virtualpairprogrammers.staffmanagement.EmployeeManagementServiceLocal;
import com.virtualpairprogrammers.staffmanagement.domain.Employee;

@ManagedBean(name="allEmployeesPageBean")
public class AllEmployeesPageBean
{
    @EJB
    private EmployeeManagementServiceLocal employeeService;
    private Employee selectedEmployee;
    private UIData dataTable;
    private UIData dataTableOld;

    public List<Employee> getAllEmployees()
    {
        return employeeService.getAllEmployees();
    }

    public String showEmployee()
    {
        this.selectedEmployee = (Employee)dataTable.getRowData();

        return "employeeDetail";
    }

    public String showEmployeeOld()
    {
        this.selectedEmployee = (Employee)dataTableOld.getRowData();

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
