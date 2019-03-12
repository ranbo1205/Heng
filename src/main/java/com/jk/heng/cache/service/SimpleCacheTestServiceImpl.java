package com.jk.heng.cache.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class SimpleCacheTestServiceImpl implements CacheTestService {
    private static final Logger logger = LoggerFactory.getLogger(SimpleCacheTestServiceImpl.class);

    private final Map<String,String> entries = new HashMap<>();

    @Autowired
    private CacheManager cacheManager;

    public SimpleCacheTestServiceImpl(){
        entries.put("1","this is num 1");
    }

    @Override
    @Cacheable(cacheNames = "test" , key="#id")
    public String get(String id) {

        // 记录数据产生的时间，用于测试对比
        long time = new Date().getTime();
        logger.info("The cache mananger is ：" +cacheManager);
        logger.info("Get value by Id : "+id+" , the time is :"+time);

        return "Get value by Id " +id  + " , return value is "+ entries.get(id);

    }

    @Override
    @CacheEvict(cacheNames = "test" , key="#id" )
    public String delete(String id) {

        logger.info("delete id : "+id);
        return "return delete id "+entries.remove(id);
    }

    @Override
    @CachePut(cacheNames = "test" , key = "#id")
    public String save(String id, String name) {

        logger.info("save id :"+id+" , name :"+name);
        entries.put(id,name);
        return "post id :"+id+" , name :"+name;
    }

    @Override
    @CachePut(cacheNames = "test" , key="#id")
    public String put(String id, String name) {
        logger.info("put id :" +id+" , name :"+name);
        entries.put(id,name);
        return "return put id :"+id+" , name :"+name;
    }
}
