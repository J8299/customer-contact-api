package com.company.customer.contactapi.service.dao;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.springframework.stereotype.Repository
public interface CustomerContactRepository extends Repository<CustomerContactEntity, String> {

    List<CustomerContactEntity> findAll();

    CustomerContactEntity findByIdEquals(Integer id);

    CustomerContactEntity save(CustomerContactEntity customerContactEntity);

    void delete(CustomerContactEntity customerContactEntity);

}
