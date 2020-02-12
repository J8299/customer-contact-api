package com.company.customer.contactapi.web;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.company.customer.contactapi.domain.CustomerContactService;
import com.company.customer.contactapi.service.dao.CustomerContactEntity;
import com.company.customer.contactapi.service.model.CustomerAddressJson;
import com.company.customer.contactapi.service.model.CustomerNameJson;
import com.company.customer.contactapi.service.model.CustomerPhoneJson;
import com.company.customer.contactapi.service.model.PhoneType;
import gherkin.deps.com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.BeanIsAbstractException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerInformationResourceTest {

  @InjectMocks
  private CustomerInformationResource customerInformationResource;

  @Mock
  private CustomerContactService customerContactService;

  private Collection<CustomerContactEntity> customerContactEntityCollection = new ArrayList<>();

  private Collection<CustomerContactEntity> entityList = new ArrayList<>();

  private MockMvc mockMvc;

  private CustomerContactEntity customerContactEntity = new CustomerContactEntity();

  private CustomerNameJson customerNameJson = new CustomerNameJson();
  private CustomerAddressJson customerAddressJson = new CustomerAddressJson();
  private CustomerPhoneJson customerPhoneJson = new CustomerPhoneJson();

  @Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mockMvc = standaloneSetup(customerInformationResource).build();
    customerNameJson.setFirst("first");
    customerNameJson.setMiddle("middle");
    customerNameJson.setLast("last");
    customerAddressJson.setStreet("street");
    customerAddressJson.setCity("city");
    customerAddressJson.setState("state");
    customerAddressJson.setZip("zip");
    customerPhoneJson.setNumber("804-555-5555");
    customerPhoneJson.setType(PhoneType.WORK);
    Collection<CustomerPhoneJson> listNumbers = Arrays.asList(customerPhoneJson);
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
  public void getAllCustomerContacts() throws Exception {
    when(customerContactService.getAllCustomers()).thenReturn(customerContactEntityCollection);
    mockMvc.perform(get("/contacts")
        .accept(MediaType.parseMediaType("application/json")))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"));
  }

  @Test(expected = NestedServletException.class)
  public void getAllCustomerContactsException() throws Exception {
    when(customerContactService.getAllCustomers()).thenThrow(new ArrayIndexOutOfBoundsException());
    mockMvc.perform(get("/contacts")
        .accept(MediaType.parseMediaType("application/json")))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"));
  }

  @Test
  public void getUniqueCustomerContact() throws Exception {
    when(customerContactService.getCustomerById(anyInt())).thenReturn(customerContactEntity);
    mockMvc.perform(get("/contacts/123")
        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test(expected = NestedServletException.class)
  public void getUniqueCustomerContactException() throws Exception {
    when(customerContactService.getCustomerById(anyInt()))
        .thenThrow(new BeanIsAbstractException("dataSource"));
    mockMvc.perform(get("/contacts/123")
        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test
  public void postNewCustomerContact() throws Exception {
    when(customerContactService.postCustomer(any(CustomerContactEntity.class)))
        .thenReturn(customerContactEntity);
    Gson gson = new Gson();
    String json = gson.toJson(customerContactEntity);
    mockMvc.perform(post("/contacts")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"));
  }

  @Test(expected = NestedServletException.class)
  public void postNewCustomerContactException() throws Exception {
    when(customerContactService.postCustomer(any(CustomerContactEntity.class)))
        .thenThrow(new BeanIsAbstractException("dataSource"));
    Gson gson = new Gson();
    String json = gson.toJson(customerContactEntity);
    mockMvc.perform(post("/contacts")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"));
  }

  @Test
  public void updateCustomerContact() throws Exception {
    when(customerContactService.updateCustomer(anyInt(), any(CustomerContactEntity.class)))
        .thenReturn(customerContactEntity);
    Gson gson = new Gson();
    String json = gson.toJson(customerContactEntity);
    mockMvc.perform(put("/contacts/123")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"));
  }

  @Test(expected = NestedServletException.class)
  public void updateCustomerContactException() throws Exception {
    when(customerContactService.updateCustomer(anyInt(), any(CustomerContactEntity.class)))
        .thenThrow(new BeanIsAbstractException("dataSource"));
    Gson gson = new Gson();
    String json = gson.toJson(customerContactEntity);
    mockMvc.perform(put("/contacts/123")
        .contentType(MediaType.APPLICATION_JSON)
        .content(json))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json"));
  }

  @Test
  public void deleteCustomerContact() throws Exception {
    when(customerContactService.deleteCustomer(anyInt())).thenReturn("123");
    mockMvc.perform(delete("/contacts/123")
        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test(expected = NestedServletException.class)
  public void deleteCustomerContactException() throws Exception {
    when(customerContactService.deleteCustomer(anyInt()))
        .thenThrow(new BeanIsAbstractException("dataSource"));
    mockMvc.perform(delete("/contacts/123")
        .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
        .andExpect(status().isOk())
        .andExpect(content().contentType("application/json;charset=UTF-8"));
  }

  @Test
  public void unregisteredEndpointException() throws Exception {
    mockMvc.perform(get("/wrongEndpoint")
        .accept(MediaType.parseMediaType("application/json")))
        .andExpect(status().is4xxClientError());
  }

}
