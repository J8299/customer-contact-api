package com.company.customer.contactapi.service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class CustomerPhoneJson implements Serializable {

  private static final long serialVersionUID = 2134739672833200601L;

  private String number;
  public PhoneType type;

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
