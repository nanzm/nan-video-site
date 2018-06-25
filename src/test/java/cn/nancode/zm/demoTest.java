package cn.nancode.zm;

import org.junit.Test;

import java.io.File;
import java.time.LocalDateTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class demoTest {

    @Test
    public void time() {
        System.out.println(LocalDateTime.now().toString());
    }

    @Test
    public void file() {
        File file = new File("test");
        System.out.println(file.delete());
    }

    @Test
    public void sendMsg() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        System.out.println(index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        fixedThreadPool.shutdown();// 局部线程池，使用完后记得要关闭
    }
}
