package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Localtioninfo;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-20 14:21:52'
 */
public interface LocaltioninfoService {

    /**
     * 查询Localtioninfo列表
     */
    List<Localtioninfo> selectLocaltioninfoList(Localtioninfo localtioninfo, int pageNum, int pageSize);

    /**
     * 通过Id查询 Localtioninfo
     */
    Localtioninfo selectLocaltioninfoById(Long bluetoothId);

    /**
     * 新增Localtioninfo
     */
    int insertLocaltioninfo(Localtioninfo localtioninfo);

    /**
     * 通过id删除Localtioninfo
     */
    int deleteLocaltioninfoById(Long bluetoothId);

    /**
     * 通过id批量删除Localtioninfo
     */
    int deleteLocaltioninfoByIds(String bluetoothIds);

    /**
     * 修改Localtioninfo信息
     */
    int updateLocaltioninfo(Localtioninfo localtioninfo);

}

