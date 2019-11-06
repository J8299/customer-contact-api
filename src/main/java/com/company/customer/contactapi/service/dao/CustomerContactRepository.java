package com.company.customer.contactapi.service.dao;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@org.springframework.stereotype.Repository
public interface CustomerContactRepository extends Repository<CustomerContactEntity, String> {

    List<CustomerContactEntity> findAll();

    CustomerContactEntity findByIdEquals(String id);

    CustomerContactEntity deleteByIdEquals(String id);

    CustomerContactEntity save(CustomerContactEntity customerContactEntity);

    Long count();

    void delete(CustomerContactEntity customerContactEntity);

    boolean existsById(String id);

}
