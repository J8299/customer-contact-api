package com.company.customer.contactapi.service.model;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class CustomerAddressJsonTest {

  private CustomerAddressJson customerAddressJson = new CustomerAddressJson();

  @Before
  public void setUp() {
    customerAddressJson.setCity("city");
    customerAddressJson.setState("state");
    customerAddressJson.setStreet("street");
    customerAddressJson.setZip("zip");
  }

  @Test
  public void getStreetTest() {
    assertThat(customerAddressJson.getStreet(), is(equalTo("street")));
  }

  @Test
  public void getCityTest() {
    assertThat(customerAddressJson.getCity(), is(equalTo("city")));
  }

  @Test
  public void getStateTest() {
    assertThat(customerAddressJson.getState(), is(equalTo("state")));
  }

  @Test
  public void getZipTest() {
    assertThat(customerAddressJson.getZip(), is(equalTo("zip")));
  }

  //    @Test
  //    void setStreet() {
  //    }
  //
  //    @Test
  //    void setCity() {
  //    }
  //
  //    @Test
  //    void setState() {
  //    }
  //
  //    @Test
  //    void setZip() {
  //    }
}
