package com.jk.heng.route.model;

import java.util.List;

public class ContactInstructionPartner {

    private ContactPartner partner;
    private List<Contact> contacts;

    public static ContactInstructionPartner create(){
        return new ContactInstructionPartner();
    }

    public ContactPartner getPartner() {
        return partner;
    }

    public void setPartner(ContactPartner partner) {
        this.partner = partner;
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }
}
