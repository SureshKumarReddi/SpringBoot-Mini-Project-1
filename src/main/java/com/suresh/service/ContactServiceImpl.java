package com.suresh.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suresh.bindings.ContactForm;
import com.suresh.entities.Contact;
import com.suresh.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository repository;

	@Override
	public String saveContact(ContactForm form) {
		Contact contact = new Contact();
		form.setActiveSw("Y");
		BeanUtils.copyProperties(form, contact);
		Contact entity = repository.save(contact);
		if (entity.getContactId() != null) {
			return "contact saved";
		}
		return "contact not saved";
	}

	@Override
	public ContactForm editContact(Integer contactId) {
		Optional<Contact> contact = repository.findById(contactId);
		if (contact.isPresent()) {
			Contact obj = contact.get();
			ContactForm contactForm = new ContactForm();
			BeanUtils.copyProperties(obj, contactForm);
			return contactForm;
		}
		return null;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contactId) {
		repository.deleteById(contactId);
		return viewContacts();
	}

	@Override
	public List<ContactForm> viewContacts() {
		List<Contact> allContacts = repository.findAll();
		List<ContactForm> contactForm = new ArrayList<>();

		for (Contact contact : allContacts) {
			ContactForm form = new ContactForm();
			BeanUtils.copyProperties(contact, form);
			contactForm.add(form);
		}
		return contactForm;

	}

}
