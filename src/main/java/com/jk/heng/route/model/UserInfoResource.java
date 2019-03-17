package com.jk.heng.route.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

import java.util.List;

public class UserInfoResource {

    private String status;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonUnwrapped
    private EmbeddedItem<UserInfo> userInfoEmbeddedItem;


    @JsonUnwrapped
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private EmbeddedItem<List<UserInfo>> userInfoEmbeddedList;

    public UserInfoResource(String status, UserInfo userInfo) {
        this.status = status;
        this.userInfoEmbeddedItem = new EmbeddedItem(userInfo);
    }
    public UserInfoResource(String status, List<UserInfo> userInfoList) {
        this.status = status;
        this.userInfoEmbeddedList = new EmbeddedItem(userInfoList);
    }


    public UserInfoResource() {

    }

    public static UserInfoResource create(String status , UserInfo userInfo){

        return new UserInfoResource(status,userInfo);
    }

    public static UserInfoResource create(String status , List<UserInfo> userInfoList){

        return new UserInfoResource(status,userInfoList);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public EmbeddedItem<UserInfo> getUserInfoEmbeddedItem() {
        return userInfoEmbeddedItem;
    }

    public void setUserInfoEmbeddedItem(EmbeddedItem<UserInfo> userInfoEmbeddedItem) {
        this.userInfoEmbeddedItem = userInfoEmbeddedItem;
    }


    public EmbeddedItem<List<UserInfo>> getUserInfoEmbeddedList() {
        return userInfoEmbeddedList;
    }

    public void setUserInfoEmbeddedList(EmbeddedItem<List<UserInfo>> userInfoEmbeddedList) {
        this.userInfoEmbeddedList = userInfoEmbeddedList;
    }

    public UserInfoResource create(){
        return new UserInfoResource();
    }
}
