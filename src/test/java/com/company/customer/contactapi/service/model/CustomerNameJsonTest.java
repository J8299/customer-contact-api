package com.company.customer.contactapi.service.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CustomerNameJsonTest {

  private CustomerNameJson customerNameJson = new CustomerNameJson();

  @Before
  public void setUp() {
    customerNameJson.setFirst("first");
    customerNameJson.setMiddle("middle");
    customerNameJson.setLast("last");
  }

  @Test
  public void getFirstTest() {
    assertThat(customerNameJson.getFirst(), is(equalTo("first")));
  }

  @Test
  public void getMiddleTest() {
    assertThat(customerNameJson.getMiddle(), is(equalTo("middle")));
  }

  @Test
  public void getLastTest() {
    assertThat(customerNameJson.getLast(), is(equalTo("last")));
  }

}
