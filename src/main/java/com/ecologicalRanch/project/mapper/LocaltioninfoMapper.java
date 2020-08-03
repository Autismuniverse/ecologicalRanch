package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Localtioninfo;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-20 14:21:52'
 */
public interface LocaltioninfoMapper {

    /**
     * 查询Localtioninfo列表
     * @param localtioninfo 查询对象
     * @return 查询列表
     */
    List<Localtioninfo> selectLocaltioninfoList(Localtioninfo localtioninfo);

    /**
     * 通过Id查询 Localtioninfo
     * @param bluetoothId 查询Id
     * @return 查询对象
     */
    Localtioninfo selectLocaltioninfoById(Long bluetoothId);

    /**
     * 新增Localtioninfo
     * @param localtioninfo 新增对象
     * @return 插入行数
     */
    int insertLocaltioninfo(Localtioninfo localtioninfo);

    /**
     * 修改Localtioninfo信息
     * @param  localtioninfo 用户对象
     * @return 更新行数
     */
    int updateLocaltioninfo(Localtioninfo localtioninfo);

    /**
     * 通过id删除Localtioninfo
     * @param bluetoothId 删除id
     * @return 删除行数
     */
    int deleteLocaltioninfoById(Long bluetoothId);

    /**
     * 通过id批量删除Localtioninfo
     * @param bluetoothIds 删除ids
     * @return 删除行数
     */
    int deleteLocaltioninfoByIds(String[] bluetoothIds);

}

