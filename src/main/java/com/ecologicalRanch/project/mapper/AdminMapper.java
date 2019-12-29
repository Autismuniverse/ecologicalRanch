package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Admin;

import java.util.List;

public interface AdminMapper {

    /**
     * 查询所有管理员信息
     * @return admin对象集
     */
    List<Admin> queryAll();

    /**
     * 通过id查询管理员信息
     * @param adminId 管理员id
     * @return 管理员对象
     */
    Admin selectById(long adminId);

    /**
     * 通过admin_id和password查询管理员信息
     * @param admin 对象
     * @return admin 对象
     */
    Admin login(Admin admin);
}
