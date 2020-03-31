package com.galvanize.dto;

public class OrderRequest {
    private String customerName;
    private String description;

    public OrderRequest(String customerName, String description) {
        this.customerName = customerName;
        this.description = description;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
