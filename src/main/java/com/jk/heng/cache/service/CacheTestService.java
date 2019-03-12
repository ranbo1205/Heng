package com.jk.heng.cache.service;

public interface CacheTestService {

    String get(String id);


    String  delete(String id);

    String save(String id, String name);

    String put(String id, String name);
}
