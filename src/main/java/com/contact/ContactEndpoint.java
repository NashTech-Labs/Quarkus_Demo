package com.contact;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/contacts")
public class ContactEndpoint {

    @Inject
    ContactResource contactResource;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Contact> getContacts() {
        return contactResource.getContacts();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Contact getContact(@PathParam("id") Long id) {
        return contactResource.getContact(id);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateContact(@PathParam("id") Long id, Contact c) {
        contactResource.updateContact(id, c);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Contact addContact(Contact c) {
        return contactResource.addContact(c);
    }

    @DELETE
    @Path("/{id}")
    public void deleteContact(@PathParam("id") Long id) {
        contactResource.deleteContact(id);
    }
}