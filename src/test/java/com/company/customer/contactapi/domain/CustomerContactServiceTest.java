package com.company.customer.contactapi.domain;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import com.company.customer.contactapi.service.dao.CustomerContactEntity;
import com.company.customer.contactapi.service.dao.CustomerContactRepository;
import com.company.customer.contactapi.service.model.CustomerAddressJson;
import com.company.customer.contactapi.service.model.CustomerNameJson;
import com.company.customer.contactapi.service.model.CustomerPhoneJson;
import com.company.customer.contactapi.service.model.PhoneType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerContactServiceTest {

  @InjectMocks
  CustomerContactService customerContactService;

  @Mock
  CustomerContactRepository customerContactRepository;

  private Collection<CustomerContactEntity> customerContactEntityCollection = new ArrayList<>();

  private List<CustomerContactEntity> entityList = new ArrayList<>();

  private CustomerContactEntity customerContactEntity = new CustomerContactEntity();

  private CustomerNameJson customerNameJson = new CustomerNameJson();
  private CustomerAddressJson customerAddressJson = new CustomerAddressJson();
  private CustomerPhoneJson customerPhoneJson = new CustomerPhoneJson();

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    customerNameJson.setFirst("first");
    customerNameJson.setMiddle("middle");
    customerNameJson.setLast("last");
    customerAddressJson.setStreet("street");
    customerAddressJson.setCity("city");
    customerAddressJson.setState("state");
    customerAddressJson.setZip("zip");
    customerPhoneJson.setNumber("804-555-5555");
    customerPhoneJson.setType(PhoneType.WORK);
    List<CustomerPhoneJson> listNumbers = Arrays.asList(customerPhoneJson);
    customerContactEntity =
        new CustomerContactEntity(
            123,
            customerNameJson,
            customerAddressJson,
            listNumbers,
            "email");

    entityList.add(customerContactEntity);
    customerContactEntityCollection.add(customerContactEntity);
  }

  @Test
  public void getAllCustomers() {
    when(customerContactRepository.findAll()).thenReturn(entityList);
    customerContactService.getAllCustomers();
  }

  @Test
  public void getCustomerById() {
    when(customerContactRepository.findByIdEquals(anyInt())).thenReturn(customerContactEntity);
    customerContactService.getCustomerById(123);
  }

  @Test
  public void postCustomer() {
    when(customerContactRepository.save(any(CustomerContactEntity.class)))
        .thenReturn(customerContactEntity);
    customerContactService.postCustomer(customerContactEntity);
  }

  @Test
  public void updateCustomer() {
    when(customerContactRepository.save(any(CustomerContactEntity.class)))
        .thenReturn(customerContactEntity);
    customerContactService.updateCustomer(123, customerContactEntity);
  }

  @Test
  public void deleteCustomer() {
    //doNothing().when(customerContactRepository).delete(any(CustomerContactEntity.class));
    customerContactService.deleteCustomer(123);
  }

}