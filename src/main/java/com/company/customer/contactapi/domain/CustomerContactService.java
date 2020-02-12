package com.company.customer.contactapi.domain;

import com.company.customer.contactapi.service.dao.CustomerContactEntity;
import com.company.customer.contactapi.service.dao.CustomerContactRepository;
import java.util.Collection;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerContactService {

  @Autowired
  private CustomerContactRepository customerContactRepository;

  public Collection<CustomerContactEntity> getAllCustomers() {
    return Collections.unmodifiableCollection(customerContactRepository.findAll());
  }

  public CustomerContactEntity getCustomerById(Integer id) {
    return customerContactRepository.findByIdEquals(id);
  }

  public CustomerContactEntity postCustomer(CustomerContactEntity customerContactEntity) {
    return customerContactRepository.save(customerContactEntity);
  }

  public CustomerContactEntity updateCustomer(Integer id,
      CustomerContactEntity customerContactEntity) {
    CustomerContactEntity mergedCustomerContact = new CustomerContactEntity(
        id,
        customerContactEntity.getName(),
        customerContactEntity.getAddress(),
        customerContactEntity.getPhone(),
        customerContactEntity.getEmail()
    );
    customerContactRepository.save(mergedCustomerContact);
    return mergedCustomerContact;
  }

  public String deleteCustomer(Integer id) {
    CustomerContactEntity deleteCustomerContact = customerContactRepository.findByIdEquals(id);
    customerContactRepository.delete(deleteCustomerContact);
    return "Successfully deleted customer id: " + id.toString();
  }

}
