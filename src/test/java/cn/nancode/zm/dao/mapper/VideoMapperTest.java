package cn.nancode.zm.dao.mapper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class VideoMapperTest {

    @Autowired
    private VideoMapper videoMapper;

    @Test
    public void insertByMapper() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "啊哈哈");
        map.put("url", "www.baidu.com");
        int i = videoMapper.insertByMapper(map);

        log.info(""+i);
    }
}