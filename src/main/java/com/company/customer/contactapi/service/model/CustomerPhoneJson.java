package com.company.customer.contactapi.service.model;

import java.io.Serializable;

public class CustomerPhoneJson implements Serializable {

    private String number;
    private PhoneType type;

    public String getNumber() {
        return number;
    };

    public PhoneType getType() {
        return type;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

}
