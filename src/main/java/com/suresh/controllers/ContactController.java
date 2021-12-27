package com.suresh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.bindings.ContactForm;
import com.suresh.service.ContactService;

@RestController
public class ContactController {

	@Autowired
    ContactService service;
	
	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form) {
		return service.saveContact(form);
		 
	}
	@GetMapping("/allcontacts")
	public List<ContactForm> viewAllContacts(){
		return service.viewContacts();
	}
	
	@GetMapping("/editcontact/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId) {
		return service.editContact(contactId);
	}
	
	@DeleteMapping("/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId){
		return service.deleteContact(contactId);
	}
}
