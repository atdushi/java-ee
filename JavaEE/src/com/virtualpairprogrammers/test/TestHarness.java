package com.virtualpairprogrammers.test;

import com.virtualpairprogrammers.staffmanagement.domain.Employee;
import com.virtualpairprogrammers.staffmanagement.domain.Note;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

public class TestHarness {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("employeeDb");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

//        employeeTest();
//        jpqlTest();

        Query q = em.createQuery("select avg(employee.salary) from Employee employee");

        double averageSalary = (Double)q.getSingleResult();

        System.out.println(averageSalary);

        tx.commit();

        em.close();
    }

    private static void jpqlTest() {
//        List<Employee> results = em
//                .createQuery("select employee from Employee employee where employee.surname = :name")
//                .setParameter("name", "Jones")
//                .getResultList();

//        List<Employee> results = em
//                .createNamedQuery("searchByFirstName")
//                .setParameter("name", "Alan")
//                .getResultList();

//        List<Object[]> results = em
//                .createQuery("select employee.firstName, employee.surname from Employee employee where employee.surname = :name")
//                .setParameter("name", "Jones")
//                .getResultList();

//        long size = (long) em
//                .createQuery("select count (employee) from Employee employee")
//                .getSingleResult();

//        Query q = em.createQuery("select avg(employee.salary) from Employee employee");
//        double averageSalary = (Double)q.getSingleResult();
    }

    private static void employeeTest() {
//        Employee employee1 = new Employee("Mark", "Briggs", "Engineer", 10000);
//        em.persist(employee1);
//        Employee employee1 = em.find(Employee.class, 1);
//        employee1.setSurname("smith");
//        em.remove(employee1);

//        Note newNote = new Note("some text");
//        em.persist(newNote);

//        Employee employee1 = new Employee("Jack", "Jones", "Programmer", 10000);
//        em.persist(employee1);
//        Note newNote = new Note("joined company today");
//        em.persist(newNote);
//        employee1.addNote("joined company today");

//        Employee employee1 = em.find(Employee.class, 151);
//        Note newNote = new Note("promoted today");
//        em.persist(newNote);
//        employee1.addNote(newNote);

//        Employee employee1 = em.find(Employee.class, 301);
//        Set<Note> allNotes = employee1.getAllNotes();
//        for (Note next : allNotes) {
//            System.out.println(next);
//        }

//        Employee employee1 = new Employee("Alan", "Jones", "Plumber", 47000);
//        em.persist(employee1);
//        employee1.addNote("one");
//        employee1.addNote("two");
    }
}
