package cn.nancode.zm.service.impl;

import cn.nancode.zm.dao.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserServiceImpl userService;

    @Test
    public void saveUser() {
        User user = new User();
        user.setName("小胖子");
        user.setEmail("msg@aa.com");
        user.setPhone("1782323733");
        user.setEncodePassword("123");
        User result = userService.saveUser(user);
        logger.info(result.toString());
    }

    @Test
    public void updateUser() {

        User user = new User();
        user.setId((long) 3);
        user.setName("xixi");
        user.setEmail("msg@aa.com");
        user.setPhone("1782323733");
        user.setEncodePassword("123");
        User result = userService.updateUser(user);
        logger.info(result.toString());
    }

    @Test
    public void removeUser() {
    }

    @Test
    public void removeUsersInBatch() {
    }

    @Test
    public void getUserById() {
    }

    @Test
    public void getUserByEmail() {
    }

    @Test
    public void listUsers() {
    }

    @Test
    public void loadUserByUsername() {
    }

    @Test
    public void listUsersByNameLike() {
    }
}