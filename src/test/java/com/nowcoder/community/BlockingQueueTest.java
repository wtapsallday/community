package com.nowcoder.community;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue queue = new ArrayBlockingQueue(10);
        new Thread(new Producer(queue), "生产者线程").start();
        new Thread(new Consumer(queue), "消费者线程1").start();
        new Thread(new Consumer(queue), "消费者线程2").start();
        new Thread(new Consumer(queue), "消费者线程3").start();
    }
}


class Producer implements Runnable{
    private BlockingQueue<Integer> queue;
    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try{
            for(int i = 0; i < 100; ++i){
                Thread.sleep(20);
                queue.put(i);
                System.out.println(Thread.currentThread().getName() + " 生产第:" + i + "次 " + queue.size());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable{
    private BlockingQueue<Integer> queue;
    public Consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try{
            while(true){
                Thread.sleep(new Random().nextInt(1000));
                queue.take();
                System.out.println(Thread.currentThread().getName() + " 消费第:" + queue.size());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}