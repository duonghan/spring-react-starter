package com.duonghv.springjs.repositories;

import com.duonghv.springjs.models.Contact;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, String> {

    @Override
    void delete(Contact entity);
}
