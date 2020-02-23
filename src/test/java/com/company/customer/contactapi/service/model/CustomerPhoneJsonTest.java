package com.company.customer.contactapi.service.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CustomerPhoneJsonTest {

  private CustomerPhoneJson customerPhoneJson = new CustomerPhoneJson();

  @Before
  public void setUp() {
    customerPhoneJson.setNumber("804-555-5555");
    customerPhoneJson.setType(PhoneType.MOBILE);
  }

  @Test
  public void getFirstTest() {
    assertThat(customerPhoneJson.getNumber(), is(equalTo("804-555-5555")));
  }

  @Test
  public void getMiddleTest() {
    assertThat(customerPhoneJson.getType(), is(equalTo(PhoneType.MOBILE)));
  }
}
