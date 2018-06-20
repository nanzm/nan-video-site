package cn.nancode.zm.repository;

import cn.nancode.zm.dao.Blog;
import cn.nancode.zm.dao.Catalog;
import cn.nancode.zm.dao.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Long> {

    // 根据用户名、博客标题分页查询博客列表
    Page<Blog> findByUserAndTitleLike(User user, String title, Pageable pageable);

    // 根据用户名、博客查询博客列表（时间逆序）
    Page<Blog> findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(String title,
                                                                            User user, String tags, User user2, Pageable pageable);
    // 根据分类查询博客列表
    Page<Blog> findByCatalog(Catalog catalog, Pageable pageable);
}
