package com.jk.heng.cache.controller;

import com.jk.heng.route.model.TResult;
import com.jk.heng.route.model.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@RestController
@RequestMapping("/")
public class UserController {

    @GetMapping("/userGet/{id}")
    public TResult<UserInfo> getUserByUserIdFromPath(@PathVariable("id") String userId){
        return getUserInfoTResult();
    }



    @GetMapping("/userFromParam")
    public TResult<UserInfo> getUserByIdFromRequestParam(@RequestParam("id") String userId){
        return getUserInfoTResult();
    }

    private TResult<UserInfo> getUserInfoTResult() {
        TResult<UserInfo> result = new TResult<>();
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("1001");
        userInfo.setUserName("YiHeng");
        userInfo.setAge(18);
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒 EE", Locale.CHINA);
        try {
            date = df.parse("2018年1月1日 16时10分00秒 星期一");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        userInfo.setBirthDate(date);

        result.setSuccess(true);
        result.setErrCode(0);
        result.setErrMsg("No Error found");
        result.setValue(userInfo);


        return result;
    }

}
