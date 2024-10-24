package com.jeremy.curso.springboot.error.springboot_error.models;

import java.util.Date;

public class Error {

    private String messagee;
    private String error;
    private int status;
    private Date date;
    
    public String getMessagee() {
        return messagee;
    }
    public void setMessagee(String messagee) {
        this.messagee = messagee;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }



}
