package com.evolent.contacts.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.evolent.contacts.model.ContactResponse;
import com.evolent.contacts.model.Contacts;

@RestController
public class ContactsController {

	@Autowired
	private ContactService service;
	
	@GetMapping("/contacts")
	public List<Contacts> getContacts(){
		System.out.println("/contacts api invoked");
		return service.getAllContacts();
	}
	
	@PostMapping("/addOrUpdateContact")
	public String addContact(@RequestBody Contacts newContact) {
		return service.addAContact(newContact);
	}
	
	@GetMapping("/contacts/{firstName}")
	public Optional<ContactResponse> findContact(@PathVariable("firstName") String firstName) {
		return service.findContact(firstName);
	}
	
	@GetMapping("/contacts/delete/{name}")
	public ContactResponse deleteContact(@PathVariable("name") String name) {
		return service.deleteContact(name);
	}
	
}
