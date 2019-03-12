package com.jk.heng.cache.util.serialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CustomSerializer extends JsonSerializer<String> {
    @Override
    public void serialize(String userId, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {

        if(null != userId){
            jsonGenerator.writeObject("txy_qq"+userId+"kwfz");
        }else{
            jsonGenerator.writeObject("Empty userId");
        }


    }
}
