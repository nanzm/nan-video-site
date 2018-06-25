package cn.nancode.zm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


/**
 * @author sufun
 */
@SpringBootApplication
@EnableRedisHttpSession
@MapperScan(basePackages = "cn/nancode/zm/dao/mapper")
public class NanSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(NanSiteApplication.class, args);
    }
}
