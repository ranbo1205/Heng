package com.jk.heng.testng.service.group;

import org.testng.annotations.Test;


/**
 * @Test(groups) on class level
 */
@Test(groups = "uiCall")
public class TestUI {

    public void runTestUI2(){
        System.out.println("runTestUI2");
    }

    public void runTestUI3(){
        System.out.println("runTestUI3");
    }
}
