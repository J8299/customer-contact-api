package com.company.customer.contactapi.service.model;

import java.io.Serializable;

public class CustomerNameJson implements Serializable {

    private String first;
    private String middle;
    private String last;

    public String getFirst() {
        return first;
    }

    public String getMiddle() {
        return middle;
    }

    public String getLast() {
        return last;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
