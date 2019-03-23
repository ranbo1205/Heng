package com.jk.heng.testng.service.parameter;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class TestParameterDataProvider {

    @Test(dataProvider = "providedNumbers" , groups = "groupB")
    public void test(int number , int expected){
        Assert.assertEquals(number+10,expected);
    }


    @DataProvider(name = "providedNumbers")
    public Object[][] providedNumData(){

        return new Object[][]{
                {10,20},
                {20,30},
                {30,40}
        };
    }


    @Test(dataProvider = "dataProviderMap",groups = "groupB")
    public void testParameterMap(Map<String,String> map){

        map.entrySet().iterator().forEachRemaining(
                entry -> {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    System.out.println("key : "+key + " , value : "+value);
                }
        );
    }

    @DataProvider(name="dataProviderMap")
    public Object[][]  getMapParameter(){
        Map<String,String> map = new HashMap<>();
        map.put("url","http://baidu.com");
        map.put("userName","rose");

        return new Object[][]{{map}};
    }

    @Test(dataProvider = "dataProvider3",groups = "groupA")
    public void test1(int number){
        Assert.assertEquals(number,1);
    }

    @Test(dataProvider = "dataProvider3",groups = "groupB")
    public void test2(int number){
        Assert.assertEquals(number,2);
    }

    @DataProvider(name="dataProvider3")
    public Object[][] getIntProviderByGroupUsingItestContext(ITestContext context){
        for(String group : context.getIncludedGroups()){
            if(group.equals("groupA")){
                return new Object[][]{{1}};
            }
        }
        return new Object[][]{{2}};
    }




}
