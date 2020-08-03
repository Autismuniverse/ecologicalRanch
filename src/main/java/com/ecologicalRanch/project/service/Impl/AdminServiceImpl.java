package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.MD5Utils;
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
    public  Admin login(Admin admin) {
        Admin result= this.selectByPhone(admin.getPhone());
        admin.setPassword(MD5Utils.string2MD5(admin.getPassword(),result.getSalt()));
        return  adminMapper.login(admin);
    }

    @Override
    public int insertAdmin(Admin admin){
        String salt = MD5Utils.salt();
        admin.setSalt(salt);
        admin.setPassword(MD5Utils.string2MD5(admin.getPassword(),salt));
        return adminMapper.insertAdmin(admin);
    }

    @Override
    public Admin selectByPhone(String phone){
        return adminMapper.selectByPhone(phone);
    }
}
