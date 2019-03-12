package com.jk.heng.route.model;

import java.util.List;

public class Person {
    Address address;
    List<Interest> interestList;

    public List<Interest> getInterestList() {
        return interestList;
    }

    public void setInterestList(List<Interest> interestList) {
        this.interestList = interestList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "address=" + address +
                ", interestList=" + interestList +
                '}';
    }
}
