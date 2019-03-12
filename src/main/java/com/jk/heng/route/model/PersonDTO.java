package com.jk.heng.route.model;

import java.util.List;

public class PersonDTO {

    String littleStreet;
    public String littleCity;

    public List<Interest> getInterestList() {
        return interestList;
    }

    public void setInterestList(List<Interest> interestList) {
        this.interestList = interestList;
    }

    List<Interest> interestList;


    public String getLittleStreet() {
        return littleStreet;
    }

    public void setLittleStreet(String littleStreet) {
        this.littleStreet = littleStreet;
    }

    public String getLittleCity() {
        return littleCity;
    }

    public void setLittleCity(String littleCity) {
        this.littleCity = littleCity;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "littleStreet='" + littleStreet + '\'' +
                ", littleCity='" + littleCity + '\'' +
                ", interestList=" + interestList +
                '}';
    }
}
