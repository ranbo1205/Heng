package com.jk.heng.testng.service.email;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RandomEmailGeneratorTest {


    @Test
    public void testEmailGenerator(){
        RandomEmailGenerator obj = new RandomEmailGenerator();
        String email = obj.generate();

        Assert.assertEquals(email,"feedback@yoursite.com");
    }
}
