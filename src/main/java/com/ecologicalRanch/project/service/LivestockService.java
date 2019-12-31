package com.ecologicalRanch.project.service;


import com.ecologicalRanch.project.entity.Livestock;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-31 15:23:10'
 */
public interface LivestockService {

    /**
     * 查询Livestock列表
     */
    List<Livestock> selectLivestockList(Livestock livestock, int pageNum, int pageSize);

    /**
     * 通过Id查询 Livestock
     */
    Livestock selectLivestockById(Long livestockId);

    /**
     * 新增Livestock
     */
    int insertLivestock(Livestock livestock);

    /**
     * 通过id删除Livestock
     */
    int deleteLivestockById(Long livestockId);

    /**
     * 通过id批量删除Livestock
     */
    int deleteLivestockByIds(String livestockIds);

    /**
     * 修改Livestock信息
     */
    int updateLivestock(Livestock livestock);

}