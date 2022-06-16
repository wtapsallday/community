package com.nowcoder.community;

import com.nowcoder.community.service.AlphaService;
import com.nowcoder.community.service.UserService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Scanner;

public class TransactionTests {

    @Autowired
    private AlphaService alphaService;

    @Test
    public void testSave1() {
        Object obj = alphaService.save1();
        System.out.println(obj);
    }

    @Test
    public void testSave2() {
        Object obj = alphaService.save2();
        System.out.println(obj);
    }
}
