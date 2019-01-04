package com.duonghv.springjs.controllers;

import com.duonghv.springjs.models.Contact;
import com.duonghv.springjs.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ContactController {

    @Autowired
    ContactRepository contactRepository;

    @RequestMapping(value="/contacts", method= RequestMethod.GET)
    public Iterable<Contact> contacts(){
        return contactRepository.findAll();
    }

    @RequestMapping(value="/contacts", method= RequestMethod.POST)
    public Contact save(@RequestBody Contact contact){
        contactRepository.save(contact);

        return contact;
    }

    @RequestMapping(value="/contacts/{id}", method= RequestMethod.GET)
    public Optional<Contact> show(@PathVariable String id){
        return contactRepository.findById(id);
    }

    @RequestMapping(value="/contacts/{id}", method= RequestMethod.PUT)
    public Contact update(@PathVariable String id, @RequestBody Contact contact){
        Optional<Contact> optionalContact = contactRepository.findById(id);

        Contact c = optionalContact.get();

        if(contact.getName() != null){
            c.setName(contact.getName());
        }

        if(contact.getAddress() != null){
            c.setName(contact.getAddress());
        }

        if(contact.getCity() != null){
            c.setName(contact.getCity());
        }

        if(contact.getEmail() != null){
            c.setName(contact.getEmail());
        }

        if(contact.getPhone() != null){
            c.setName(contact.getPhone());
        }

        contactRepository.save(c);
        return c;
    }

    @RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable String id){
        Optional<Contact> optionalContact = contactRepository.findById(id);

        Contact contact = optionalContact.get();
        contactRepository.delete(contact);

        return "";
    }

}
