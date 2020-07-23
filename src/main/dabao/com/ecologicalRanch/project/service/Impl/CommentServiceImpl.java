package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Comment;
import com.ecologicalRanch.project.mapper.CommentMapper;
import com.ecologicalRanch.project.service.CommentService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author XXXFredYang
 * @date '2020-07-23 14:55:28'
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 通过Id查询 Comment
     */
    @Override
    public Comment selectCommentById(Long commentId) {
        return commentMapper.selectCommentById(commentId);
    }

    /**
     * 查询Comment列表
     */

    @Override
    public List<Comment> selectCommentList(Comment comment,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->commentMapper.selectCommentList(comment));
    }

    /**
     * 新增Comment
     */
    @Override
    public int insertComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }

    /**
     * 通过id删除Comment
     */
    @Override
    public int deleteCommentById(Long commentId) {
        return commentMapper.deleteCommentById(commentId);
    }

    /**
     * 通过id批量删除Comment
     */
    @Override
    public int deleteCommentByIds(String commentIds){
        return commentMapper.deleteCommentByIds(Convert.toStrArray(commentIds));
    }

    /**
     * 修改Comment信息
     */
    @Override
    public int updateComment(Comment comment) {
        return commentMapper.updateComment(comment);
    }

}

