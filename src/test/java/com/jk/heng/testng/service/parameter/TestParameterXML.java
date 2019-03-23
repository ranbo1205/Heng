package com.jk.heng.testng.service.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class TestParameterXML {

    Connection con;

    @Test
    @Parameters({"dbconfig","poolsize"})
    public void createConnection(String dbconfig, int poolsize){

        System.out.println("dbconfig: "+dbconfig);
        System.out.println("poolsize: "+poolsize);

        Properties prop = new Properties();

        InputStream inputStream = null;

        try{

            inputStream = getClass().getClassLoader().getResourceAsStream(dbconfig);
            prop.load(inputStream);

            String drivers = prop.getProperty("jdbc.driver");
            String connectionURL = prop.getProperty("jdbc.url");
            String username = prop.getProperty("jdbc.username");
            String password = prop.getProperty("jdbc.password");

            System.out.println("drivers : " + drivers);
            System.out.println("connectionURL : " + connectionURL);
            System.out.println("username : " + username);
            System.out.println("password : " + password);

            Class.forName(drivers);
            con = DriverManager.getConnection(connectionURL,username,password);
        }catch (Exception e){
            System.err.println(e);
        }finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


}
