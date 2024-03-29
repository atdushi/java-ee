package com.virtualpairprogrammers.dataaccess;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.virtualpairprogrammers.staffmanagement.domain.Employee;

// Java EE > 5 => можно без интерфейса для @Local EJB
//@Stateless => можно не делать из него EJB

@ProductionDao
public class EmployeeDataAccessImplementation implements EmployeeDataAccess {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Employee> findAll() {
		Query q = em.createQuery("select employee from Employee employee");
		return q.getResultList();
	}

	@Override
	public List<Employee> findBySurname(String surname) {
		Query q = em.createQuery("select employee from Employee employee where employee.surname = :surname");
		q.setParameter("surname", surname);
		return q.getResultList();
	}

	@Override
	public void insert(Employee newEmployee) {
		em.persist(newEmployee);
	}

	@Override
	public Employee findById(int id) throws EmployeeNotFoundException{
		Employee employee = em.find(Employee.class, id);
		if (employee == null)
		{
			throw new EmployeeNotFoundException();
		}

		return employee;
	}

	@Override
	public void deleteById(int id) throws EmployeeNotFoundException {
		Employee foundEmployee = findById(id);
		em.remove(foundEmployee);
	}
}
