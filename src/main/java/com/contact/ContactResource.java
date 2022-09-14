package com.contact;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Singleton
public class ContactResource {

    @Inject
    EntityManager entityManager;

    public List<Contact> getContacts() {
        return entityManager.createQuery("SELECT c FROM Contact c").getResultList();
    }

    public Contact getContact(Long id) {
        return entityManager.find(Contact.class, id);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Contact addContact(Contact contact) {
        entityManager.persist(contact);
        return contact;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void updateContact(Long id, Contact contact) {
        Contact contactToUpdate = entityManager.find(Contact.class, id);
        if (null != contactToUpdate) {
            contactToUpdate.setFirstName(contact.getFirstName());
            contactToUpdate.setLastName(contact.getLastName());
            contactToUpdate.setCompanyName(contact.getCompanyName());
        } else {
            throw new RuntimeException("No such contact available");
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void deleteContact(Long id) {
        Contact contact = getContact(id);
        entityManager.remove(contact);
    }
}
