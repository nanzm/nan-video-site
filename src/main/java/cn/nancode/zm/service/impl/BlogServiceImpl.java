package cn.nancode.zm.service.impl;

import cn.nancode.zm.dao.*;
import cn.nancode.zm.repository.BlogRepository;
import cn.nancode.zm.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Transactional
    @Override
    public Blog saveBlog(Blog blog) {
        return blogRepository.save(blog);
    }

    @Transactional
    @Override
    public void removeBlog(Long id) {
        blogRepository.delete(id);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public Page<Blog> listBlogsByTitleVote(User user, String title, Pageable pageable) {
        // 模糊查询
        title = "%" + title + "%";
        String tags = title;
        Page<Blog> blogs = blogRepository.findByTitleLikeAndUserOrTagsLikeAndUserOrderByCreateTimeDesc(title,
                user, tags, user, pageable);
        return blogs;
    }

    @Override
    public Page<Blog> listBlogsByTitleVoteAndSort(User user, String title, Pageable pageable) {
        // 模糊查询
        title = "%" + title + "%";
        Page<Blog> blogs = blogRepository.findByUserAndTitleLike(user, title, pageable);
        return blogs;
    }

    @Override
    public void readingIncrease(Long id) {
        Blog blog = blogRepository.findOne(id);
        if (blog != null) {
            blog.setReadSize(blog.getReadSize() + 1); // 在原有的阅读量基础上递增1
            this.saveBlog(blog);
        }
    }

    @Override
    public Blog createComment(Long blogId, String commentContent) {
        Blog blog = blogRepository.findOne(blogId);
        if (blog != null) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Comment comment = new Comment(commentContent, user);
            blog.addComment(comment);
        }
        return this.saveBlog(blog);
    }

    @Override
    public void removeComment(Long blogId, Long commentId) {
        Blog blog = blogRepository.findOne(blogId);
        if (blog != null) {
            blog.removeComment(commentId);
            this.saveBlog(blog);
        }
    }

    @Override
    public Blog createVote(Long blogId) {
        Blog blog = blogRepository.findOne(blogId);

        if (blog != null) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Vote vote = new Vote(user);
            boolean isExist = blog.addVote(vote);
            if (isExist) {
                throw new IllegalArgumentException("该用户已经点过赞了");
            }
        }

        return this.saveBlog(blog);
    }

    @Override
    public void removeVote(Long blogId, Long voteId) {
        Blog blog = blogRepository.findOne(blogId);

        if (blog != null) {
            blog.removeVote(voteId);
            this.saveBlog(blog);
        }
    }

    @Override
    public Page<Blog> listBlogsByCatalog(Catalog catalog, Pageable pageable) {
        Page<Blog> blogs = blogRepository.findByCatalog(catalog, pageable);
        return blogs;
    }
}
