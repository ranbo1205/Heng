package com.jk.heng.route.modelmapper;

import com.jk.heng.route.model.Address;
import com.jk.heng.route.model.Interest;
import com.jk.heng.route.model.Person;
import com.jk.heng.route.model.PersonDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;

import java.util.ArrayList;
import java.util.List;

public class TestModelMapper {

    public static void main(String [] args){

        Person person = getPerson();


        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(Person.class, PersonDTO.class);

        // create property map
        PropertyMap<Person,PersonDTO> personPersonDTOPropertyMap = new PropertyMap<Person, PersonDTO>() {
            @Override
            protected void configure() {
                map().setLittleCity(source.getAddress().getCity());
                map().setLittleStreet(source.getAddress().getStreet());
                map().setInterestList(source.getInterestList());
            }
        };
        // 方法一: use PropertyMap
//        modelMapper.addMappings(personPersonDTOPropertyMap);


        // 方法二:use Converter
        modelMapper.addConverter(getConverter());

        PersonDTO result = modelMapper.map(person,PersonDTO.class);

        System.out.println(result);



    }

    private static Converter<Person, PersonDTO> getConverter() {
        final Converter<Person, PersonDTO> converter = new Converter<Person, PersonDTO>() {
            @Override
            public PersonDTO convert(MappingContext<Person, PersonDTO> mappingContext) {
                Person person = mappingContext.getSource();
                if (person == null) {
                    return null;
                }
                PersonDTO personDTO = new PersonDTO();
                personDTO.setInterestList(person.getInterestList());
                personDTO.setLittleStreet(person.getAddress().getStreet());
                personDTO.setLittleCity(person.getAddress().getCity());
                return personDTO;
            }
        };
        return converter;
    }

    private static Person getPerson() {
        Person person = new Person();
        Address address = new Address();
        address.setStreet("MaLuan Street");
        address.setCity("ShenZhen");
        person.setAddress(address);

        Interest basketBall = new Interest();
        basketBall.setInterestName("basket ball");
        basketBall.setType("Ball Type");

        Interest run = new Interest();
        run.setInterestName("running");
        run.setType("Walk Type");

        List<Interest> interestList = new ArrayList<>();
        interestList.add(basketBall);
        interestList.add(run);
        person.setInterestList(interestList);
        return person;
    }


}
