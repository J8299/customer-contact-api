package com.company.customer.contactapi.service.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.company.customer.contactapi.service.model.CustomerAddressJson;
import com.company.customer.contactapi.service.model.CustomerNameJson;
import com.company.customer.contactapi.service.model.CustomerPhoneJson;
import com.company.customer.contactapi.service.model.PhoneType;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerContactEntityTest {

  private CustomerAddressJson customerAddressJson = new CustomerAddressJson();
  private CustomerNameJson customerNameJson = new CustomerNameJson();
  private CustomerPhoneJson customerPhoneJson = new CustomerPhoneJson();
  private CustomerContactEntity customerContactEntity = new CustomerContactEntity();

  @BeforeEach
  public void setUp() {
    customerAddressJson.setStreet("street");
    customerAddressJson.setCity("city");
    customerAddressJson.setState("state");
    customerAddressJson.setZip("zip");
    customerNameJson.setFirst("first");
    customerNameJson.setMiddle("middle");
    customerNameJson.setLast("last");
    customerPhoneJson.setNumber("804-555-5555");
    customerPhoneJson.setType(PhoneType.HOME);
    Collection<CustomerPhoneJson> phoneList = new ArrayList<>();
    phoneList.add(customerPhoneJson);

    customerContactEntity =
        new CustomerContactEntity(
            123, customerNameJson, customerAddressJson, phoneList, "email@gmail.com");
  }

  @Test
  public void getIdTest() {
    assertEquals(customerContactEntity.getId(), 123);
  }

  @Test
  public void getNameTest() {
    assertEquals(customerContactEntity.getName().getFirst(), "first");
    assertEquals(customerContactEntity.getName().getMiddle(), "middle");
    assertEquals(customerContactEntity.getName().getLast(), "last");
  }

  @Test
  public void getAddressTest() {
    assertEquals(customerContactEntity.getAddress().getStreet(), "street");
    assertEquals(customerContactEntity.getAddress().getCity(), "city");
    assertEquals(customerContactEntity.getAddress().getState(), "state");
    assertEquals(customerContactEntity.getAddress().getZip(), "zip");
  }

  @Test
  public void getPhoneListTest() {
    Collection<CustomerPhoneJson> phoneList = new ArrayList<>();
    CustomerPhoneJson customerPhoneJson = new CustomerPhoneJson();
    customerPhoneJson.setNumber("804-555-5555");
    customerPhoneJson.setType(PhoneType.HOME);
    phoneList.add(customerPhoneJson);
    assertEquals(
        customerContactEntity.getPhone().iterator().next().getNumber(),
        phoneList.iterator().next().getNumber());
    assertEquals(
        customerContactEntity.getPhone().iterator().next().getType(),
        phoneList.iterator().next().getType());
  }

  @Test
  public void getEmailTest() {
    assertEquals(customerContactEntity.getEmail(), "email@gmail.com");
  }
}
