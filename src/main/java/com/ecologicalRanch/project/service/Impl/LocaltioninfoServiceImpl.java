package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.project.entity.Localtioninfo;
import com.ecologicalRanch.project.mapper.LocaltioninfoMapper;
import com.ecologicalRanch.project.service.LocaltioninfoService;
import com.ecologicalRanch.utils2.Convert;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-20 14:21:52'
 */
@Service
public class LocaltioninfoServiceImpl implements LocaltioninfoService {

    @Autowired
    private LocaltioninfoMapper localtioninfoMapper;

    /**
     * 通过Id查询 Localtioninfo
     */
    @Override
    public Localtioninfo selectLocaltioninfoById(Long bluetoothId) {
        return localtioninfoMapper.selectLocaltioninfoById(bluetoothId);
    }

    /**
     * 查询Localtioninfo列表
     */

    @Override
    public List<Localtioninfo> selectLocaltioninfoList(Localtioninfo localtioninfo, int pageNum, int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->localtioninfoMapper.selectLocaltioninfoList(localtioninfo));
    }

    /**
     * 新增Localtioninfo
     */
    @Override
    public int insertLocaltioninfo(Localtioninfo localtioninfo) {
        return localtioninfoMapper.insertLocaltioninfo(localtioninfo);
    }

    /**
     * 通过id删除Localtioninfo
     */
    @Override
    public int deleteLocaltioninfoById(Long bluetoothId) {
        return localtioninfoMapper.deleteLocaltioninfoById(bluetoothId);
    }

    /**
     * 通过id批量删除Localtioninfo
     */
    @Override
    public int deleteLocaltioninfoByIds(String bluetoothIds){
        return localtioninfoMapper.deleteLocaltioninfoByIds(Convert.toStrArray(bluetoothIds));
    }

    /**
     * 修改Localtioninfo信息
     */
    @Override
    public int updateLocaltioninfo(Localtioninfo localtioninfo) {
        return localtioninfoMapper.updateLocaltioninfo(localtioninfo);
    }

}
