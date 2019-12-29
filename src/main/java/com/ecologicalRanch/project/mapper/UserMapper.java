package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.User;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-18 13:29:26'
 */
public interface UserMapper {

    /**
     * 查询User列表
     * @param user 查询对象
     * @return 查询列表
     */
    List<User> selectUserList(User user);

    /**
     * 通过Id查询 User
     * @param userId 查询Id
     * @return 查询对象
     */
    User selectUserById(Long userId);

    /**
     * 新增User
     * @param user 新增对象
     * @return 插入行数
     */
    int insertUser(User user);

    /**
     * 修改User信息
     * @param  user 用户对象
     * @return 更新行数
     */
    int updateUser(User user);

    /**
     * 通过id删除User
     * @param userId 删除id
     * @return 删除行数
     */
    int deleteUserById(Long userId);

    /**
     * 通过id批量删除User
     * @param userIds 删除ids
     * @return 删除行数
     */
    int deleteUserByIds(String[] userIds);

}
