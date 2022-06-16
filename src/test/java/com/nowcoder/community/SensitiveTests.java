package com.nowcoder.community;

import com.nowcoder.community.util.SensitiveFilter;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class SensitiveTests {

    @Autowired
    private SensitiveFilter sensitiveFilter;

    @Test
    public void testSensitiveFilter(){
        String text = "这里可以吸毒，可以嫖娼，可以开票，哈哈哈哈";
        text = sensitiveFilter.filter(text);
        System.out.println(text);

        text = "这里可以吸☆毒☆，可以☆嫖娼☆，可以开☆票，哈哈哈哈";
        text = sensitiveFilter.filter(text);
        System.out.println(text);
    }
}
