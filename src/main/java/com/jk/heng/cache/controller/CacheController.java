package com.jk.heng.cache.controller;

import com.jk.heng.cache.service.CacheTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cache")
public class CacheController {

    @Autowired
    private CacheTestService cacheTestService;


    /*
    根据 某个 id 获取信息
     */
    @GetMapping("/get/{id}")
    public String get( @PathVariable("id") String id){
        return cacheTestService.get(id);
    }

    @DeleteMapping(path = "/delete/{id}")
    public String delete(@PathVariable("id") String id){
        return cacheTestService.delete(id);
    }

    @PostMapping("/post")
    public String save(@RequestParam("id") String id ,@RequestParam("name") String name){
        return cacheTestService.save(id,name);
    }

    @PutMapping("/put/{id}")
    public String update(@PathVariable("id") String id ,@RequestParam("name") String name){
        return cacheTestService.put(id,name);
    }




}
