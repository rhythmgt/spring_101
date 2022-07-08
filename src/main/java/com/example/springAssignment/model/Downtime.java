package com.example.springAssignment.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.DateTimeException;

@Entity
public class Downtime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String provider;

    private String flow;

    private Timestamp downFrom;

    private Timestamp downTo;

    public Downtime() {
    }

    public Downtime(Long id, String provider, String flow, Timestamp downFrom, Timestamp downTo) {
        this.id = id;
        this.provider = provider;
        this.flow = flow;
        this.downFrom = downFrom;
        this.downTo = downTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getFlow() {
        return flow;
    }

    public void setFlow(String flow) {
        this.flow = flow;
    }

    public Timestamp getDownFrom() {
        return downFrom;
    }

    public void setDownFrom(Timestamp downFrom) {
        this.downFrom = downFrom;
    }

    public Timestamp getDownTo() {
        return downTo;
    }

    public void setDownTo(Timestamp downTo) {
        this.downTo = downTo;
    }
}
