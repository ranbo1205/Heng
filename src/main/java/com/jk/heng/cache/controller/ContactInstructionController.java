package com.jk.heng.cache.controller;

import com.jk.heng.route.model.*;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.jk.heng.route.model.ContactInstructionPartner.create;

@RestController
@RequestMapping("/")
public class ContactInstructionController {


    /*
    embedded:{

        contactInstructions:[
        {

            roles:"POA,LPOA",
                    embedded:{

            partner:{

                partnerId:"ty333";
                firstName:"Jim"
                lastName:"Green"

            }
            contacts:[
            {
                contact:"13823789175",
                        contactTypes:"CT_MOBILE,CT_HOME"

            }
					]
        }
        }
	]

    }

    */





    @GetMapping(value = "/getContactInstructionList" , produces = "application/hal+json")
    public ResponseEntity<ContactInstructionResource> getContactInstructionList(){

        ContactInstruction contactInstruction = ContactInstruction.create();

        List<String> roles = Arrays.asList("POA,LPOA");

        ContactInstructionPartner contactInstructionPartner = create();

        ContactPartner contactPartner = ContactPartner.create();
        contactPartner.setFirstName("Jim");
        contactPartner.setLastName("Green");
        contactPartner.setPartnerId("321283200801010099");

        List<Contact> contacts = new ArrayList<>();
        Contact contact1 = Contact.create();
        contact1.setContact("13823789175");
        contact1.setContactTypes(Arrays.asList("CT_HOME,CT_MOBILE"));

        Contact contact2 = Contact.create();
        contact2.setContact("18823316037");
        contact2.setContactTypes(Arrays.asList("CT_VACATION,CT_ENMERGENCY"));

        contacts.add(contact1);
        contacts.add(contact2);

        contactInstructionPartner.setPartner(contactPartner);
        contactInstructionPartner.setContacts(contacts);

        contactInstruction.setRoles(roles);
        contactInstruction.setContactInstructionPartner(contactInstructionPartner);

        List<ContactInstruction> contactInstructionList = new ArrayList<>();
        contactInstructionList.add(contactInstruction);

        ContactInstructionResource contactInstructionResource = ContactInstructionResource.create();

       //  use 泛型 产生 embedded
        contactInstructionResource.setStatus("SUCCESS");
        contactInstructionResource.setListEmbeddedEntity(contactInstructionList);

        return new ResponseEntity(contactInstructionResource, HttpStatus.OK);

    }


    @GetMapping(value = "/getUserResource" , produces = "application/hal+json")
    public Resource<UserInfo> getUserInfoResource(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("jack");
        Resource<UserInfo> resource = new Resource<>(userInfo,new Link("http://info.epam.com"));
        return resource;
    }

    @GetMapping(value = "/getUser" , produces = "application/hal+json")
    public UserInfo getUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("jack");
        return userInfo;
    }


    @GetMapping("/getUserEmbeddedItem")
    public UserInfoResource getUserInfoEmbeddedItem(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("rose");
        return UserInfoResource.create("SUCCESS",userInfo);


        // 返回 Embedded list
//        List<UserInfo> userInfoList = new ArrayList<>();
//        userInfoList.add(userInfo);
//
//        return UserInfoResource.create("SUCCESS",userInfoList);

    }



}