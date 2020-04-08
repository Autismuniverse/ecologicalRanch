package com.ecologicalRanch.project.service.Impl;


import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Livestock;
import com.ecologicalRanch.project.mapper.LivestockMapper;
import com.ecologicalRanch.project.service.LivestockService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-31 15:23:10'
 */
@Service
public class LivestockServiceImpl implements LivestockService {

    @Autowired
    private LivestockMapper livestockMapper;

    /**
     * 通过Id查询 Livestock
     */
    @Override
    public Livestock selectLivestockById(Long livestockId) {
        return livestockMapper.selectLivestockById(livestockId);
    }

    /**
     * 查询Livestock列表
     */

    @Override
    public List<Livestock> selectLivestockList(Livestock livestock,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->livestockMapper.selectLivestockList(livestock));
    }

    /**
     * 新增Livestock
     */
    @Override
    public int insertLivestock(Livestock livestock) {
        return livestockMapper.insertLivestock(livestock);
    }

    /**
     * 通过id删除Livestock
     */
    @Override
    public int deleteLivestockById(Long livestockId) {
        return livestockMapper.deleteLivestockById(livestockId);
    }

    /**
     * 通过id批量删除Livestock
     */
    @Override
    public int deleteLivestockByIds(String livestockIds){
        return livestockMapper.deleteLivestockByIds(Convert.toStrArray(livestockIds));
    }

    /**
     * 修改Livestock信息
     */
    @Override
    public int updateLivestock(Livestock livestock) {
        return livestockMapper.updateLivestock(livestock);
    }

    /**
     * 模糊查询 Livestock
     */
    @Override
    public List<Livestock> fuzzyLivestockList(Livestock livestock,int pageNum,int pageSize) {

        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->livestockMapper.fuzzyLivestockList(livestock));

    }

    /**
     * 查询Livestock步數列表
     */

    @Override
    public List<Livestock> selectStep(Livestock livestock,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->livestockMapper.selectStep(livestock));
    }

    /**
     * 查询Livestock品种列表
     */

    @Override
    public List<Livestock> selectPrice(Livestock livestock,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->livestockMapper.selectPrice(livestock));
    }

}
