package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Admin;

import java.util.List;

public interface AdminService {

    List<Admin> queryAll();

    Admin selectById(long userId);

    Admin login(Admin admin);

    int insertAdmin(Admin admin);
}
