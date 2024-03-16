package com.virtualpairprogrammers.staffmanagement.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * <a href="https://stackoverflow.com/questions/21708013/java-database-connection-cant-connect-to-derby-database-netbeans-7-4">derby</a>
 *
 * ij.bat
 * connect 'jdbc:derby://localhost:1527/EmployeeDB;create=true';
 */
@Entity
//@Table(name = "TBL_EMPL")
@XmlRootElement // for jax-rs
public class Employee implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    //    @Column(name = "VC_FIRST")
    private String firstName;
    private String surname;
    private String jobRole;
    private int salary;
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_employee_id")    // чтобы не создавать employee_note таблицу
    private Set<Note> notes;

    public Employee() {
        // required by JPA
    }

    public Employee(String firstName, String surname, String jobRole, int salary) {
        super();
        notes = new HashSet<Note>();
        this.firstName = firstName;
        this.surname = surname;
        this.jobRole = jobRole;
        this.salary = salary;
    }

    public String toString() {
        return "Employee " + this.firstName + " " + this.surname;
    }

    public void addNote(String newNoteText)
    {
        Note newNote = new Note(newNoteText);
        this.notes.add(newNote);
    }

    public Set<Note> getAllNotes() {
        return notes;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJobRole() {
        return jobRole;
    }

    public void setJobRole(String jobRole) {
        this.jobRole = jobRole;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
