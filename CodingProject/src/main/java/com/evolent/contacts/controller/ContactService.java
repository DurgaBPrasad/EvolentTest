package com.evolent.contacts.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.evolent.contacts.model.ContactResponse;
import com.evolent.contacts.model.Contacts;
import com.evolent.contacts.services.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository repo;

	List<Contacts> contactList = new ArrayList<Contacts>();

	public List<Contacts> getAllContacts() {
		repo.findAll().forEach(contact -> contactList.add(contact));
		return contactList;
	}

	public String addAContact(Contacts newContact) {
		repo.save(newContact);
		return "contact updated";
		
	}

	public Optional<ContactResponse> findContact(String firstName) {
		ContactResponse contact = new ContactResponse();
		if(!repo.findById(firstName).isPresent()) {
			contact.setFirstName(firstName);
			contact.setMsg("contact not found");
			return Optional.of(contact);
		}else {
			return repo.findById(firstName).flatMap(cont ->{
				contact.setFirstName(cont.getFirstName());
				contact.setLastName(cont.getLastName());
				contact.setPhoneNo(cont.getPhoneNo());
				contact.setEmail(cont.getEmail());
				contact.setStatus(cont.getStatus());
				contact.setMsg("contact found");
				return Optional.of(contact);
			});
			}
	}

	public ContactResponse deleteContact(String firstName) {
		repo.deleteById(firstName);
		ContactResponse contact = new ContactResponse();
		contact.setMsg("contact has been deleted");
		return contact;
	}

}
