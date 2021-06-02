package com.evolent.contacts.services;

import org.springframework.data.repository.CrudRepository;
import com.evolent.contacts.model.Contacts;

public interface ContactRepository extends CrudRepository<Contacts, String>{

}
