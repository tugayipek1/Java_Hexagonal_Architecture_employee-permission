package com.phexum.wf.domain.log.entity;

import java.util.Date;

public class PermissionLog {
    private Long id;
    private Date date = new Date();
    private String message;


    public PermissionLog() {
    }

    public PermissionLog(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
