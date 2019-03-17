package com.jk.heng.route.model;

import com.fasterxml.jackson.annotation.*;
import org.springframework.hateoas.Resources;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ContactInstructionResource {

    private String status;

    private Resources<ContactInstruction> contactInstructions;

    @JsonUnwrapped
    private EmbeddedEntity<List<ContactInstruction>> listEmbeddedEntity;

    public ContactInstructionResource(String status, List<ContactInstruction> contactInstructions) {
        this.status = status;
        this.contactInstructions = new Resources(contactInstructions);
    }

    public ContactInstructionResource() {

    }

    public static ContactInstructionResource create(String status ,List<ContactInstruction> contactInstructions){

        return new ContactInstructionResource(status,contactInstructions);
    }

    public static ContactInstructionResource create(){
        return new ContactInstructionResource();
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Resources<ContactInstruction> getContactInstructions() {
        return contactInstructions;
    }

    public void setContactInstructions(List<ContactInstruction> contactInstructions) {
        this.contactInstructions = new Resources(contactInstructions);
    }

    public EmbeddedEntity<List<ContactInstruction>> getListEmbeddedEntity() {
        return listEmbeddedEntity;
    }

    public void setListEmbeddedEntity(EmbeddedEntity<List<ContactInstruction>> listEmbeddedEntity) {
        this.listEmbeddedEntity = listEmbeddedEntity;
    }

    public void setListEmbeddedEntity(List<ContactInstruction> listEmbeddedEntity) {
        this.listEmbeddedEntity = new EmbeddedEntity<>(listEmbeddedEntity);
    }
}
