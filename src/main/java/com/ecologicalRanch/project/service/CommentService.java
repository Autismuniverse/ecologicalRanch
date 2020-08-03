package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Comment;

import java.util.List;



/**
 *
 *
 * @author XXXFredYang
 * @date '2020-07-23 14:55:28'
 */
public interface CommentService {

    /**
     * 查询Comment列表
     */
    List<Comment> selectCommentList(Comment comment, int pageNum, int pageSize);

    /**
     *
     * @param fieldId
     * @return
     */
    List<Comment> selectCommentUserByFieldId(Long fieldId);

    /**
     * 通过Id查询 Comment
     */
    Comment selectCommentById(Long commentId);

    /**
     * 新增Comment
     */
    int insertComment(Comment comment);

    /**
     * 通过id删除Comment
     */
    int deleteCommentById(Long commentId);

    /**
     * 通过id批量删除Comment
     */
    int deleteCommentByIds(String commentIds);

    /**
     * 修改Comment信息
     */
    int updateComment(Comment comment);

}
