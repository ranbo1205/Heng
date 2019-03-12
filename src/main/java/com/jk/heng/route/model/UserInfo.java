package com.jk.heng.route.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.jk.heng.cache.util.serialize.CustomSerializer;

import java.util.Date;

public class UserInfo {

    @JsonSerialize(using = CustomSerializer.class)
    private String userId;
    private String userName;
    @JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss")
    private Date birthDate;
    private int age;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
