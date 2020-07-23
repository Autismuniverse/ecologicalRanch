package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.MD5Utils;
import com.ecologicalRanch.project.entity.User;
import com.ecologicalRanch.project.mapper.UserMapper;
import com.ecologicalRanch.project.service.UserService;
import com.ecologicalRanch.utils2.Convert;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-18 13:29:26'
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 通过Id查询 User
     */
    @Override
    public User selectUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }

    /**
     * 查询User列表
     */

    @Override
    public List<User> selectUserList(User user,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->userMapper.selectUserList(user));
    }

    @Override
    public User login(User user){
        user.setUserPwd(MD5Utils.string2MD5(user.getUserPwd(),user.getSalt()));
        return userMapper.login(user);
    }
    /**
     * 新增User
     */
    @Override
    public int insertUser(User user) {
        String salt=MD5Utils.salt();
        user.setSalt(salt);
        user.setUserPwd(MD5Utils.string2MD5(user.getUserPwd(),salt));
        return userMapper.insertUser(user);
    }

    /**
     * 通过id删除User
     */
    @Override
    public int deleteUserById(Long userId) {
        return userMapper.deleteUserById(userId);
    }

    /**
     * 通过id批量删除User
     */
    @Override
    public int deleteUserByIds(String userIds){
        return userMapper.deleteUserByIds(Convert.toStrArray(userIds));
    }

    /**
     * 修改User信息
     */
    @Override
    public int updateUser(User user) {
        String salt=MD5Utils.salt();
        user.setSalt(salt);
        user.setUserPwd(MD5Utils.string2MD5(user.getUserPwd(),salt));
        return userMapper.updateUser(user);
    }

}