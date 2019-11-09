package com.company.customer.contactapi.service.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface CustomerContactRepository extends CrudRepository<CustomerContactEntity, String> {

    List<CustomerContactEntity> findAll();

    CustomerContactEntity findByIdEquals(String id);

    CustomerContactEntity deleteByIdEquals(String id);

    CustomerContactEntity save(CustomerContactEntity customerContactEntity);

    void delete(CustomerContactEntity customerContactEntity);

    boolean existsById(String id);

}
