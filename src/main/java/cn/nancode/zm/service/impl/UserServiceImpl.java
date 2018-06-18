package cn.nancode.zm.service.impl;

import cn.nancode.zm.dao.User;
import cn.nancode.zm.repository.UserRepository;
import cn.nancode.zm.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * User: nan-computer
 * Date: 2018/6/3 19:23
 * Description:
 */
@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private Logger logger = LoggerFactory.getLogger((getClass()));

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        return repository.save(user);
    }

    @Transactional
    @Override
    public void removeUser(Long id) {
        repository.delete(id);
    }

    @Transactional
    @Override
    public void removeUsersInBatch(List<User> users) {
        repository.deleteInBatch(users);
    }

    @Override
    public User getUserById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<User> listUsers() {
        return repository.findAll();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.info("登录用户名为：" + username);

        //邮箱作为 用户名
        User user = getUserByEmail(username);

        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("账号名错误");
        }
    }

    @Override
    public Page<User> listUsersByNameLike(String name, Pageable pageable) {
        //模糊查询
        name = "%" + name + "%";
        Page<User> users = repository.findByNameLike(name, pageable);
        return users;
    }
}
