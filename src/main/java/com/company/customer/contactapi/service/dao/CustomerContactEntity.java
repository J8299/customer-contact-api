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
import java.util.Collection;

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
    private Integer id;

    @Column(name = "name")
    @Type(type = "CustomerName")
    private CustomerNameJson name;

    @Column(name = "address")
    @Type(type = "CustomerAddress")
    private CustomerAddressJson address;

    @Column(name = "phone")
    @Type(type = "CustomerPhone")
    private Collection<CustomerPhoneJson> phone;

    @Column(name = "email")
    private String email;

    public CustomerContactEntity(
            Integer id,
            CustomerNameJson customerNameJson,
            CustomerAddressJson customerAddressJson,
            Collection<CustomerPhoneJson> customerPhoneJson,
            String email
    ) {
        this.id = id;
        this.name = customerNameJson;
        this.address = customerAddressJson;
        this.phone = customerPhoneJson;
        this.email = email;
    }

    public CustomerContactEntity() {};

    public Integer getId() {
        return id;
    }

    public CustomerNameJson getName() {
        return name;
    }

    public CustomerAddressJson getAddress() {
        return address;
    }

    public Collection<CustomerPhoneJson> getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

}
