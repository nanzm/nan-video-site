package cn.nancode.zm.repository;

import cn.nancode.zm.dao.Catalog;
import cn.nancode.zm.dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatalogRepository extends JpaRepository<Catalog, Long> {

    List<Catalog> findByUser(User user);

    List<Catalog> findByUserAndName(User user, String name);
}