package cn.nancode.zm.repository;

import cn.nancode.zm.dataobject.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * User: nan-computer
 * Date: 2018/6/3 19:13
 * Description:
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByNameLike(String name, Pageable pageable);

    User findByEmail(String email);
}
