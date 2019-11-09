package com.company.customer.contactapi.service.dao;

import com.company.customer.contactapi.service.model.CustomerAddressJson;
import com.company.customer.contactapi.service.model.CustomerNameJson;
import com.company.customer.contactapi.service.model.CustomerPhoneJson;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(description = "Representation of Customer Contacts")
@Entity
@Table(name = "customerContactInfo")
@TypeDefs({
        @TypeDef(name = "CustomerName", typeClass = CustomerNameJson.class),
        @TypeDef(name = "CustomerAddress", typeClass = CustomerAddressJson.class),
        @TypeDef(name = "CustomerPhone", typeClass = CustomerPhoneJson.class)
})
public class CustomerContactEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    @Type(type = "CustomerName")
    private CustomerNameJson customerNameJson;

    @Column(name = "address")
    @Type(type = "CustomerAddress")
    private CustomerAddressJson customerAddressJson;

    @Column(name = "phone")
    @Type(type = "CustomerPhone")
    private CustomerPhoneJson customerPhoneJson;

    @Column(name = "email")
    private String email;

    public CustomerContactEntity(
            String id,
            CustomerNameJson customerNameJson,
            CustomerAddressJson customerAddressJson,
            CustomerPhoneJson customerPhoneJson,
            String email
    ) {
        super();
        this.id = id;
        this.customerNameJson = customerNameJson;
        this.customerAddressJson = customerAddressJson;
        this.customerPhoneJson = customerPhoneJson;
        this.email = email;
    }

    public CustomerContactEntity() {};

    public String getId() {
        return id;
    }

    public CustomerNameJson getCustomerNameJson() {
        return customerNameJson;
    }

    public CustomerAddressJson getCustomerAddressJson() {
        return customerAddressJson;
    }

    public CustomerPhoneJson getCustomerPhoneJson() {
        return customerPhoneJson;
    }

    public String getEmail() {
        return email;
    }

//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public void setCustomerNameJson(CustomerNameJson customerNameJson) {
//        this.customerNameJson = customerNameJson;
//    }
//
//    public void setCustomerAddressJson(CustomerAddressJson customerAddressJson) {
//        this.customerAddressJson = customerAddressJson;
//    }
//
//    public void setCustomerPhoneJson(CustomerPhoneJson customerPhoneJson) {
//        this.customerPhoneJson = customerPhoneJson;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

}
