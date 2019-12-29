package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Admin;

import java.util.List;

public interface IAdminService {

    List<Admin> queryAll();

    Admin selectById(long userId);

    Admin login(Admin admin);
}
