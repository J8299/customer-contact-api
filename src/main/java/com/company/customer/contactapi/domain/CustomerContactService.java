package com.company.customer.contactapi.domain;

import com.company.customer.contactapi.service.dao.CustomerContactEntity;
import com.company.customer.contactapi.service.dao.CustomerContactRepository;

import javax.inject.Inject;
import java.util.Collection;

public class CustomerContactService {

    @Inject
    private CustomerContactRepository customerContactRepository;

    public Collection<CustomerContactEntity> getAllCustomer() {
        return customerContactRepository.findAll();
    }

    public CustomerContactEntity getByCustomerId(String id) {
        return customerContactRepository.findByIdEquals(id);
    }

    public CustomerContactEntity createNewCustomerContact(CustomerContactEntity customerContactEntity) {
        customerContactRepository.save(customerContactEntity);
        return customerContactEntity;
    }

    public CustomerContactEntity overwriteCustomerContact(String id, CustomerContactEntity newCustomerContact) {
        CustomerContactEntity mergedCustomerContact = new CustomerContactEntity(
                id,
                newCustomerContact.getCustomerNameJson(),
                newCustomerContact.getCustomerAddressJson(),
                newCustomerContact.getCustomerPhoneJson(),
                newCustomerContact.getEmail()
        );
        if (customerContactRepository.existsById(id)) {
            customerContactRepository.save(mergedCustomerContact);
        }
        return mergedCustomerContact;
    }

    public String deleteCustomerContact(String id) {
        customerContactRepository.deleteByIdEquals(id);
        return "Successfully deleted id: " + id;
    }

}
