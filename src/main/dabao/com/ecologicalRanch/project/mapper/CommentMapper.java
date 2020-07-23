package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Comment;

import java.util.List;


/**
 *
 *
 * @author XXXFredYang
 * @date '2020-07-23 14:55:28'
 */
public interface CommentMapper {

    /**
     * 查询Comment列表
     * @param comment 查询对象
     * @return 查询列表
     */
    List<Comment> selectCommentList(Comment comment);

    /**
     * 通过Id查询 Comment
     * @param commentId 查询Id
     * @return 查询对象
     */
    Comment selectCommentById(Long commentId);

    /**
     * 新增Comment
     * @param comment 新增对象
     * @return 插入行数
     */
    int insertComment(Comment comment);

    /**
     * 修改Comment信息
     * @param  comment 用户对象
     * @return 更新行数
     */
    int updateComment(Comment comment);

    /**
     * 通过id删除Comment
     * @param commentId 删除id
     * @return 删除行数
     */
    int deleteCommentById(Long commentId);

    /**
     * 通过id批量删除Comment
     * @param commentIds 删除ids
     * @return 删除行数
     */
    int deleteCommentByIds(String[] commentIds);

}

