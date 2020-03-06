package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.project.entity.Admin;
import com.ecologicalRanch.project.mapper.AdminMapper;
import com.ecologicalRanch.project.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public List<Admin> queryAll(){ return adminMapper.queryAll();}

    @Override
    public  Admin selectById(long adminId) { return adminMapper.selectById(adminId); }

    @Override
    public  Admin login(Admin admin) { return  adminMapper.login(admin);}
}
