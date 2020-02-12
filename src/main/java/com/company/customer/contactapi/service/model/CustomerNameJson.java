package com.company.customer.contactapi.service.model;

import java.io.Serializable;

public class CustomerNameJson implements Serializable {

  private static final long serialVersionUID = -7076581696262831406L;

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
