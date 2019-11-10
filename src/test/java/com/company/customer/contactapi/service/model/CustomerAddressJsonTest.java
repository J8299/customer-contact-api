package com.company.customer.contactapi.service.model;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

class CustomerAddressJsonTest {

    private CustomerAddressJson customerAddressJson;

    @Before
    void setUp() {
        customerAddressJson.setCity("city");
        customerAddressJson.setState("state");
        customerAddressJson.setStreet("street");
        customerAddressJson.setZip("zip");
    }

    @Test
    void getStreet() {
        assertThat(customerAddressJson.getStreet(), is(equalTo("street")));
    }

    @Test
    void getCity() {
        assertThat(customerAddressJson.getCity(), is(equalTo("city")));
    }

    @Test
    void getState() {
        assertThat(customerAddressJson.getState(), is(equalTo("state")));
    }

    @Test
    void getZip() {
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