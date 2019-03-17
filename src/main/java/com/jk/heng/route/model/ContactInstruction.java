package com.jk.heng.route.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import org.springframework.hateoas.core.Relation;

import java.util.List;

@Relation(value = "contactInstruction" , collectionRelation = "contactInstructions")
public class ContactInstruction {

    private List<String> roles;

    @JsonUnwrapped
    private EmbeddedEntity<ContactInstructionPartner> contactInstructionPartner;

    public static ContactInstruction create(){
        return new ContactInstruction();
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public EmbeddedEntity<ContactInstructionPartner> getContactInstructionPartner() {
        return contactInstructionPartner;
    }

    public void setContactInstructionPartner(ContactInstructionPartner contactInstructionPartner) {
        this.contactInstructionPartner = new EmbeddedEntity(contactInstructionPartner);
    }
}
