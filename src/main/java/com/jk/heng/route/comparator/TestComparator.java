package com.jk.heng.route.comparator;

import com.jk.heng.route.model.UserInfo;

import java.util.ArrayList;
import java.util.List;

public class TestComparator {

    public static void main(String[] args){

        sortByString(getUserInfos());


    }

    private static void sortByString(List<UserInfo> userInfoList) {
        userInfoList.sort((u1, u2)->u1.getUserName().compareTo(u2.getUserName()));

        userInfoList.iterator().forEachRemaining(u->System.out.println(u.getUserName()));
    }

    private static List<UserInfo> getUserInfos() {
        UserInfo userInfo1= new UserInfo();
        userInfo1.setUserName("a");

        UserInfo userInfo2 = new UserInfo();
        userInfo2.setUserName("d");

        UserInfo userInfo3 = new UserInfo();
        userInfo3.setUserName("c");

        UserInfo userInfo4 = new UserInfo();
        userInfo4.setUserName("b");


        List<UserInfo> userInfoList = new ArrayList<>();
        userInfoList.add(userInfo1);
        userInfoList.add(userInfo2);
        userInfoList.add(userInfo3);
        userInfoList.add(userInfo4);
        return userInfoList;
    }


}
