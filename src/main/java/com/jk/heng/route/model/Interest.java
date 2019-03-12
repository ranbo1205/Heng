package com.jk.heng.route.model;

public class Interest {
    String interestName;
    String type;

    public String getInterestName() {
        return interestName;
    }

    public void setInterestName(String interestName) {
        this.interestName = interestName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Interest{" +
                "interestName='" + interestName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
