package com.nowcoder.community;

import com.mysql.cj.log.Log;
import com.mysql.cj.log.LogFactory;
import com.nowcoder.community.service.AlphaService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class ThreadPoolTests {
    private static final Logger logger =  LoggerFactory.getLogger(ThreadPoolTests.class);

    //JDK普通线程池
    private ExecutorService excutorService = Executors.newFixedThreadPool(5);

    //JDK可定时执行任务的线程池
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    //spring 普通线程池
    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    //Spring 可执行定时任务的线程池
    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    @Autowired
    private AlphaService alphaService;

    private void sleep(long m){
        try {
            Thread.sleep(m);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //1、 JDK普通线程池
    @Test
    public void testExcutorService(){
        Runnable task = new Runnable() {
            @Override
            public void run() {
                logger.debug("Hello ExcutorService");
            }
        };
        for(int i = 0; i < 10; ++i){
            excutorService.submit(task);
        }
        sleep(10000);
    }

    //2、JDK定时任务线程池
    @Test
    public void testScheduleExcutorService(){
        Runnable task = new Runnable() {
            @Override
            public void run() {
                logger.debug("Hello ScheduleExcutorService");
            }
        };

        scheduledExecutorService.scheduleAtFixedRate(task, 10000, 1000, TimeUnit.MILLISECONDS);
        sleep(30000);
    }

    @Test
    //3、Spring 普通线程池
    public void testThreadPoolTaskExcutor(){
        Runnable task = new Runnable() {
            @Override
            public void run() {
                logger.debug("Hello ThreadPoolTaskExecutor");
            }
        };
        for(int i = 0; i < 10; ++i){
            taskExecutor.submit(task);
        }
        sleep(10000);
    }
    //4、Spring定时任务线程池
    @Test
    public void testThreadPoolTaskScheduler(){
        Runnable task = new Runnable() {
            @Override
            public void run() {
                logger.debug("Hello ThreadPoolTaskScheduler");
            }
        };

        Date startTime = new Date(System.currentTimeMillis() + 10000);
        taskScheduler.scheduleAtFixedRate(task, startTime, 1000);

        sleep(30000);
    }

    //5、Spring 普通线程池
    @Test
    public void testThreadPoolTaskExcutorSimple(){
        for(int i = 0; i < 10; ++i){
            alphaService.execute1();
        }
        sleep(10000);
    }

    //6、spring定时任务线程池（简化）
    @Test
    public void testThreadPoolTaskSchedulerSimple(){
        sleep(30000);
    }
}
