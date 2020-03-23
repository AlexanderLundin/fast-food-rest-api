package com.galvanize.dto;

import com.galvanize.entities.Status;

public class OrderUpdate {
    private String customerName;
    private Status status;
    private String note;

    public OrderUpdate() {
    }

    public OrderUpdate(String customerName, Status status, String note) {
        this.customerName = customerName;
        this.status = status;
        this.note = note;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
