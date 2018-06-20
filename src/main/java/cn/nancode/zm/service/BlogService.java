package cn.nancode.zm.service;

import cn.nancode.zm.dao.Blog;
import cn.nancode.zm.dao.Catalog;
import cn.nancode.zm.dao.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BlogService {

    //保存Blog
    Blog saveBlog(Blog blog);

    void removeBlog(Long id);

    //根据id获取Blog
    Blog getBlogById(Long id);

    Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable);

    Page<Blog> listBlogsByTitleVoteAndSort(User user, String title, Pageable pageable);

    void readingIncrease(Long id);

    Blog createComment(Long blogId, String commentContent);

    void removeComment(Long blogId, Long commentId);

    Blog createVote(Long blogId);

    void removeVote(Long blogId, Long voteId);

    Page<Blog> listBlogsByCatalog(Catalog catalog, Pageable pageable);
}
