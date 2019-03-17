package com.jk.heng.route.model;

import java.util.List;

public class Contact {

    private String contact;
    private List<String> contactTypes;

    public static Contact create(){
        return new Contact();
    }
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public List<String> getContactTypes() {
        return contactTypes;
    }

    public void setContactTypes(List<String> contactTypes) {
        this.contactTypes = contactTypes;
    }
}
