package com.company.customer.contactapi.service.model;

import com.vladmihalcea.hibernate.type.array.StringArrayType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import java.io.Serializable;

@TypeDef(name = "string-array", typeClass = StringArrayType.class)
public class CustomerPhoneJson implements Serializable {

    private String number;

    @Type(type = "string-array")
    private String[] type;

    public String getNumber() {
        return number;
    };

    public String[] getType() {
        return type.clone();
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setType(String... type) {
        this.type = type;
    }

}
