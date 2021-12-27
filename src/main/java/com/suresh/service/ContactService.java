package com.suresh.service;

import java.util.List;

import com.suresh.bindings.ContactForm;

public interface ContactService {

	public String saveContact(ContactForm form);
	public ContactForm editContact(Integer contactId);
	public List<ContactForm> deleteContact(Integer contactId);
	public List<ContactForm> viewContacts();
}
