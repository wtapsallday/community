package com.nowcoder.community;

//import org.junit.runner.RunWith;
import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.LoginTicketMapper;
import com.nowcoder.community.dao.MessageMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.LoginTicket;
import com.nowcoder.community.entity.Message;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.util.CommunityUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import sun.util.locale.LocaleMatcher;

import java.util.Date;
import java.util.List;

//@Runwith
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LoginTicketMapper loginTicketMapper;
    @Autowired
    private DiscussPostMapper discussPostMapper;
    @Autowired
    private MessageMapper messageMapper;
    @Test
    public void testSelectUser(){
         User user = userMapper.selectById(150);
         System.out.println(user);
         user = userMapper.selectByName("liubei");
         System.out.println(user);
         user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("hejiani");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("248122658@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());
    }
    @Test
    public void updateUser(){
       int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "www.dsah.com");
        System.out.println(rows);

        rows = userMapper.updatePassword(150, "126281");
        System.out.println(rows);

    }

    @Test
    public void testSelectPosts(){
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0,0,10, 0);
        for(DiscussPost discussPost : list){
            System.out.println(discussPost);
        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);
    }

    @Test
    public void testInsertLoginTicket(){
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setTicket("abc");
        loginTicket.setStatus(0);
        loginTicket.setExpired(new Date(System.currentTimeMillis() + 1000 * 60 * 10));
        loginTicketMapper.insertLoginTicket(loginTicket);
    }

    @Test
    public void testSelectLoginTicket(){
        LoginTicket loginTicket = loginTicketMapper.selectByTicket("abc");

        System.out.println(loginTicket);

        loginTicketMapper.updateStatus("abc", 1);
        loginTicket = loginTicketMapper.selectByTicket("abc");
        System.out.println(loginTicket);
    }

    @Test
    public void  testSelectLetters(){
       List<Message> list = messageMapper.selectConversations(111,0,10);
        for(Message message : list){
            System.out.println(message);
        }
       int cnt = messageMapper.selectConversationCount(111);
        System.out.println(cnt);

       list =  messageMapper.selectLetters("111_112",0,10);
       for (Message message : list){
           System.out.println(message);
       }

       cnt = messageMapper.selectLetterCount("111_112");
        System.out.println(cnt);

        cnt = messageMapper.selectLetterUnreadCount(131, "111_131");
        System.out.println(cnt);
    }
}
