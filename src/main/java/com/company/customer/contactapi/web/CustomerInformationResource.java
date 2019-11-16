package com.company.customer.contactapi.web;

import com.company.customer.contactapi.domain.CustomerContactService;
import com.company.customer.contactapi.service.dao.CustomerContactEntity;
import io.swagger.annotations.*;
import org.glassfish.jersey.server.JSONP;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Named
@Component
@Singleton
@RestController
@Api(value = "/contacts")
@RequestMapping("/contacts")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerInformationResource {

    @Inject
    private CustomerContactService customerContactService;

    private final String SERVICE_NOT_FOUND = "Service not found";
    private final String SERVER_ERROR = "Server error";

    private final String GET_INTENT = "Get details for customer contact";
    private final String POST_INTENT = "Saving customer contact information";
    private final String PUT_INTENT = "Overwrite saved customer contact information";
    private final String DELETE_INTENT = "Permanently remove customer contact information";
    private final String ID_PARAM = "The ID used to search for customer contact information";

    @GET
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = GET_INTENT, response = CustomerContactEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = SERVICE_NOT_FOUND),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = SERVER_ERROR)
    })
    public Collection<CustomerContactEntity> getAllCustomerContacts() throws Exception{
        try{
            return Collections.unmodifiableCollection(customerContactService.getAllCustomers());
        } catch (Exception ex) {
            throw new Exception("Unable to return list of customers", ex);
        }
    }

    @GET
    @Path("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = GET_INTENT, response = CustomerContactEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = SERVICE_NOT_FOUND),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = SERVER_ERROR)
    })
    public CustomerContactEntity getUniqueCustomerContact(
            @ApiParam(value = ID_PARAM, name = "id", required = true, allowMultiple = false)
            @PathVariable("id") String id
    ) throws Exception {
        try {
            return customerContactService.getCustomerById(Integer.parseInt(id));
        } catch (Exception ex) {
            throw new Exception("Unable to return customer id: " + id, ex);
        }
    }

    @POST
    @RequestMapping(method = RequestMethod.POST)
    @JSONP(queryParam = JSONP.DEFAULT_QUERY)
    @ApiOperation(value = POST_INTENT, response = CustomerContactEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = SERVICE_NOT_FOUND),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = SERVER_ERROR)
    })
    public CustomerContactEntity postNewCustomerContact(
            @RequestBody CustomerContactEntity customerContactEntity
    ) throws Exception {
        try {
            return customerContactService.postCustomer(customerContactEntity);
        } catch (Exception ex) {
            throw new Exception("Unable to create customer id: " + customerContactEntity.getId().toString(), ex);
        }
    }

    @PUT
    @Path("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @JSONP(queryParam = JSONP.DEFAULT_QUERY)
    @ApiOperation(value = PUT_INTENT, response = CustomerContactEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = SERVICE_NOT_FOUND),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = SERVER_ERROR)
    })
    public CustomerContactEntity updateCustomerContact(
            @ApiParam(value = ID_PARAM, name = "id", required = true, allowMultiple = false)
            @PathVariable("id") String id,
            @RequestBody CustomerContactEntity newCustomerContact
    ) throws Exception {
        try {
            return customerContactService.updateCustomer(Integer.parseInt(id), newCustomerContact);
        } catch (Exception ex) {
            throw new Exception("Unable to overwrite customer id: " + id.toString(), ex);
        }
    }


    @DELETE
    @Path("/{id}")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = DELETE_INTENT, response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = SERVICE_NOT_FOUND),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = SERVER_ERROR)
    })
    public String deleteCustomerContact(
            @ApiParam(value = ID_PARAM, name = "id", required = true, allowMultiple = false)
            @PathVariable("id") String id
    ) throws Exception {
        try {
            return customerContactService.deleteCustomer(Integer.parseInt(id));
        } catch (Exception ex) {
            throw new Exception("Unable to remove customer id: " + id.toString(), ex);
        }
    }

}
