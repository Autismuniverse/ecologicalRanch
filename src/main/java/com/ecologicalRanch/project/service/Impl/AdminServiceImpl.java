package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.project.entity.Admin;
import com.ecologicalRanch.project.mapper.AdminMapper;
import com.ecologicalRanch.project.service.IAdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements IAdminService {

    @Resource
    private AdminMapper adminMapper;

    @Override
    public List<Admin> queryAll(){ return adminMapper.queryAll();}

    @Override
    public  Admin selectById(long adminId) { return adminMapper.selectById(adminId); }

    @Override
    public  Admin login(Admin admin) { return  adminMapper.login(admin);}
}
