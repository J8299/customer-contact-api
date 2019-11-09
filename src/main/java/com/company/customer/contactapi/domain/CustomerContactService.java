package com.company.customer.contactapi.domain;

import com.company.customer.contactapi.service.dao.CustomerContactEntity;
import com.company.customer.contactapi.service.dao.CustomerContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Service
public class CustomerContactService {

    @Autowired
    private CustomerContactRepository customerContactRepository;

    public Collection<CustomerContactEntity> getAllCustomers(){
        Collection<CustomerContactEntity> customerContactEntityCollection =
                new ArrayList<>();
        customerContactRepository.findAll().forEach(customerContactEntityCollection::add);
        return Collections.unmodifiableCollection(customerContactEntityCollection);
    }

    public CustomerContactEntity getCustomerById(String id) {
        return customerContactRepository.findByIdEquals(id);
    }

    public CustomerContactEntity postCustomer(CustomerContactEntity customerContactEntity){
        return customerContactRepository.save(customerContactEntity);
    }

    public CustomerContactEntity updateCustomer(String id, CustomerContactEntity customerContactEntity){
        CustomerContactEntity mergedCustomerContact = new CustomerContactEntity(
                id,
                customerContactEntity.getCustomerNameJson(),
                customerContactEntity.getCustomerAddressJson(),
                customerContactEntity.getCustomerPhoneJson(),
                customerContactEntity.getEmail()
        );
        customerContactRepository.save(mergedCustomerContact);
        return mergedCustomerContact;
    }

    public String deleteCustomer(String id){
        CustomerContactEntity deleteCustomerContact = customerContactRepository.findByIdEquals(id);
        customerContactRepository.delete(deleteCustomerContact);
        return "Successfully deleted customer id: " + id;
    }

}
