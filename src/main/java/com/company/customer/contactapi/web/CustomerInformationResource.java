package com.company.customer.contactapi.web;

import com.company.customer.contactapi.domain.CustomerContactService;
import com.company.customer.contactapi.service.dao.CustomerContactEntity;
import io.swagger.annotations.*;
import org.glassfish.jersey.server.JSONP;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CustomerInformationResource {

    private CustomerContactService customerContactService = new CustomerContactService();

    private final String SERVICE_NOT_FOUND = "Service not found";
    private final String SERVER_ERROR = "Server error";

    private final String GET_INTENT = "Get details for customer contact";
    private final String POST_INTENT = "Saving customer contact information";
    private final String PUT_INTENT = "Overwrite saved customer contact information";
    private final String DELETE_INTENT = "Permanently remove customer contact information";
    private final String ID_PARAM = "The UUID used to search for customer contact information";

    @GET
    @Path("/contacts")
    @ApiOperation(value = GET_INTENT, response = CustomerContactEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = SERVICE_NOT_FOUND),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = SERVER_ERROR)
    })
    public Collection<CustomerContactEntity> getAllCustomerContacts() throws Exception{
        Collection<CustomerContactEntity> listOfCustomers = new ArrayList<CustomerContactEntity>();
        try {
            listOfCustomers = customerContactService.getAllCustomer();
        } catch (Exception ex) {
            throw new Exception("Unable to return list of customers", ex);
        }
        return Collections.unmodifiableCollection(listOfCustomers);
    }

    @GET
    @Path("/contacts/{id}")
    @ApiOperation(value = GET_INTENT, response = CustomerContactEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = SERVICE_NOT_FOUND),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = SERVER_ERROR)
    })
    public CustomerContactEntity getUniqueCustomerContact(
            @ApiParam(value = ID_PARAM, name = "id", required = true, allowMultiple = false) @PathParam("id") String id
    ) throws Exception {
        try {
            return customerContactService.getByCustomerId(id);
        } catch (Exception ex) {
            throw new Exception("Unable to return customer id: " + id, ex);
        }
    }

    @POST
    @Path("/contacts")
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
            return customerContactService.createNewCustomerContact(customerContactEntity);
        } catch (Exception ex) {
            throw new Exception("Unable to create customer id: " + customerContactEntity.getId(), ex);
        }
    }

    @PUT
    @Path("/contacts/{id}")
    @JSONP(queryParam = JSONP.DEFAULT_QUERY)
    @ApiOperation(value = PUT_INTENT, response = CustomerContactEntity.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = SERVICE_NOT_FOUND),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = SERVER_ERROR)
    })
    public CustomerContactEntity updateCustomerContact(
            @ApiParam(value = ID_PARAM, name = "id", required = true, allowMultiple = false) @PathParam("id") String id,
            @RequestBody CustomerContactEntity newCustomerContact
    ) throws Exception {
        try {
            return customerContactService.overwriteCustomerContact(id, newCustomerContact);
        } catch (Exception ex) {
            throw new Exception("Unable to overwrite customer id: " + id, ex);
        }
    }


    @DELETE
    @Path("/contacts/{id}")
    @ApiOperation(value = DELETE_INTENT, response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = HttpURLConnection.HTTP_NOT_FOUND, message = SERVICE_NOT_FOUND),
            @ApiResponse(code = HttpURLConnection.HTTP_INTERNAL_ERROR, message = SERVER_ERROR)
    })
    public String deleteCustomerContact(
            @ApiParam(value = ID_PARAM, name = "id", required = true, allowMultiple = false) @PathParam("id") String id
    ) throws Exception {
        try {
            return customerContactService.deleteCustomerContact(id);
        } catch (Exception ex) {
            throw new Exception("Unable to remove customer id: " + id, ex);
        }
    }

}
