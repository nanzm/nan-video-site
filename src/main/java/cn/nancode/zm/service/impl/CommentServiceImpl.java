package cn.nancode.zm.service.impl;

import cn.nancode.zm.dao.Comment;
import cn.nancode.zm.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Override
    public Comment getCommentById(Long id) {
        return null;
    }

    @Override
    public void removeComment(Long id) {

    }
}
