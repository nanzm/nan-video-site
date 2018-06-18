package cn.nancode.zm.repository;

import cn.nancode.zm.dao.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by nan
 * 2018/6/18
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}