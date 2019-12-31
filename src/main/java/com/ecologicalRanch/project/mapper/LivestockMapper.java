package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Livestock;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-31 15:23:10'
 */
public interface LivestockMapper {

    /**
     * 查询Livestock列表
     * @param livestock 查询对象
     * @return 查询列表
     */
    List<Livestock> selectLivestockList(Livestock livestock);

    /**
     * 通过Id查询 Livestock
     * @param livestockId 查询Id
     * @return 查询对象
     */
    Livestock selectLivestockById(Long livestockId);

    /**
     * 新增Livestock
     * @param livestock 新增对象
     * @return 插入行数
     */
    int insertLivestock(Livestock livestock);

    /**
     * 修改Livestock信息
     * @param  livestock 用户对象
     * @return 更新行数
     */
    int updateLivestock(Livestock livestock);

    /**
     * 通过id删除Livestock
     * @param livestockId 删除id
     * @return 删除行数
     */
    int deleteLivestockById(Long livestockId);

    /**
     * 通过id批量删除Livestock
     * @param livestockIds 删除ids
     * @return 删除行数
     */
    int deleteLivestockByIds(String[] livestockIds);

}

