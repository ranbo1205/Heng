package com.jk.heng.testng.service.group;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * test  @BeforeGroups , @AfterGroups, dependsOnGroups
 */
public class TestGroup {

    @BeforeGroups("connectDB")
    public void setupDB(){
        System.out.println("setupDB");
    }

    @AfterGroups("connectDB")
    public void cleanDB(){
        System.out.println("cleanDB");
    }


    @Test(groups = "connectDB")
    public void testConnectOracle(){
        System.out.println("testConnectOracle()");
    }

    @Test(groups = "connectDB")
    public void testConnectMysql(){
        System.out.println("testConnectMysql()");
    }

    @Test(groups = "uiCall")
    public void runUITest(){
        System.out.println("runUITest()");
    }

    @Test(dependsOnGroups = {"connectDB","uiCall"})
    public void runFinal(){
        System.out.println("runFinal()");
    }

}
