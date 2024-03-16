package com.virtualpairprogrammers.staffmanagement;

import com.virtualpairprogrammers.staffmanagement.domain.Employee;

import javax.ejb.Stateless;

@Stateless
public class ExternalPayrollSystem {
    public void enrollEmployee(Employee newEmployee) throws SystemUnavailableException
    {
        if (Math.random() < 0.5)
            throw new SystemUnavailableException();
        else
        {
            // do some complex processing.
        }
    }
}
