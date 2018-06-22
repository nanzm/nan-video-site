package cn.nancode.zm;

import org.junit.Test;

import java.io.File;
import java.time.LocalDateTime;

public class demoTest {


    @Test
    public void time() {
        System.out.println(LocalDateTime.now().toString());
    }


    @Test
    public void File(){
        File file = new File("test");
        System.out.println(file.delete());
    }
}
