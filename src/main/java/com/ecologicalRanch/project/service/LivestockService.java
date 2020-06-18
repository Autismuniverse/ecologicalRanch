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
     * 查询Livestock列表无分页
     */
    List<Livestock> selectLivestockListNoPageHelper(Livestock livestock);

    /**
     * 查询LivestockIds列表无分页
     */
    List<Livestock> selectLivestockListByIds(String livestockIds);
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

    /**
     * 模糊查询Livestock信息
     */
    List<Livestock> fuzzyLivestockList(Livestock livestock,int pageNum, int pageSize);

    /**
     * 查询Livestock步數列表
     */
    List<Livestock> selectStep(Livestock livestock, int pageNum, int pageSize);

    /**
     * 查询Livestock出售时间
     */
    List<Livestock> selectOutTime(Livestock livestock);

    String selectLivestockPrice(String livestockIds);


    /**
     * 更新步数
     * @param livestock
     * @return
     */
    int updateLivestockStep(Livestock livestock);
}
