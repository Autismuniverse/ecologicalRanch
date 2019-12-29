package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.User;

import java.util.List;

import java.util.Map;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-18 13:29:26'
 */
public interface UserService {

    /**
     * 查询User列表
     */
    List<User> selectUserList(User user,int pageNum,int pageSize);

    /**
     * 通过Id查询 User
     */
    User selectUserById(Long userId);

    /**
     * 新增User
     */
    int insertUser(User user);

    /**
     * 通过id删除User
     */
    int deleteUserById(Long userId);

    /**
     * 通过id批量删除User
     */
    int deleteUserByIds(String userIds);

    /**
     * 修改User信息
     */
    int updateUser(User user);

}

