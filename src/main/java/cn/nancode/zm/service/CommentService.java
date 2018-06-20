package cn.nancode.zm.service;

import cn.nancode.zm.dao.Comment;

public interface CommentService {

    Comment getCommentById(Long id);

    void removeComment(Long id);
}
