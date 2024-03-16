package com.virtualpairprogrammers.staffmanagement.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Note  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String text;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Note() {

    }

    public Note(String text) {
        date = new Date();
        this.text = text;
    }

    public String toString()
    {
        return "Note raised at " + this.date + " with contents " + this.text;
    }
}
