package com.jk.heng.route.serialize;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jk.heng.route.model.UserInfo;
import net.sf.json.JSONArray;
import  net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 两种方式 序列化 Json
 *
 * 1.json-lib (JSONObject,JSONArray)
 *
 * 2.Jackson 框架 (ObjectMapper,JsonGenerator)
 */
public class TestSerialize {

    public static void main(String [] args){

        UserInfo user = new UserInfo();
        user.setUserId("1002");
//        user.setBirthDate(new Date());
        user.setAge(18);
        user.setUserName("YiHeng");

        List<UserInfo> list = new ArrayList<>();
        list.add(user);


        // 方法一 : 使用json-lib  (JSONObject , JSONArray)
        JSONObject jsonObject = new JSONObject();
        JSONObject str = jsonObject.fromObject(user);
        System.out.println("JSONObject string :"+str);

        JSONArray jsonArray = new JSONArray();
        JSONArray array = jsonArray.fromObject(list);
        System.out.println("JSONArray :" + array);


        // 方法二: 使用 Jackson 框架（ObjectMapper , JSONGenerator）
        ObjectMapper objectMapper = new ObjectMapper();
        JsonGenerator jsonGenerator = null;
        try{
            jsonGenerator = objectMapper.getFactory().createGenerator(System.out, JsonEncoding.UTF8);
            System.out.println("---------------------------------------");
            System.out.println("Write Single Object :");
            jsonGenerator.writeObject(user);
            System.out.println();

            System.out.println("---------------------------------------");
            System.out.println("Write array :");
            jsonGenerator.writeObject(list);
            System.out.println();






        }catch (Exception e){
            System.err.println(e.getStackTrace());
        }




    }

}
