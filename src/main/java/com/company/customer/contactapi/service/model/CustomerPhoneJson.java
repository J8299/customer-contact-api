package com.company.customer.contactapi.service.model;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.io.Serializable;

@TypeDef(name = "string-array", typeClass = StringArrayType.class)
public class CustomerPhoneJson implements Serializable {

    private String phoneNumber;

    @Type(type = "string-array")
    private String[] phoneNumberTypes;

    public String getPhoneNumber() {
        return phoneNumber;
    };

    public String[] getPhoneNumberTypes() {
        return phoneNumberTypes.clone();
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPhoneNumberTypes(String... phoneNumberTypes) {
        this.phoneNumberTypes = phoneNumberTypes.clone();
    }

}
