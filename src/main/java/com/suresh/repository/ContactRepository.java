package com.suresh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suresh.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
