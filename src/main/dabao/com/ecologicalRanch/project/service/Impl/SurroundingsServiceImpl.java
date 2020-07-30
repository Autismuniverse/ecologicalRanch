package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Surroundings;
import com.ecologicalRanch.project.mapper.SurroundingsMapper;
import com.ecologicalRanch.project.service.SurroundingsService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author XXXFredYang
 * @date '2020-07-29 15:43:26'
 */
@Service
public class SurroundingsServiceImpl implements SurroundingsService {

    @Autowired
    private SurroundingsMapper surroundingsMapper;

    /**
     * 通过Id查询 Surroundings
     */
    @Override
    public Surroundings selectSurroundingsByFieldId(Integer fieldId) {
        return surroundingsMapper.selectSurroundingsByFieldId(fieldId);
    }

    /**
     * 查询Surroundings列表
     */

    @Override
    public List<Surroundings> selectSurroundingsList(Surroundings surroundings, int pageNum, int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->surroundingsMapper.selectSurroundingsList(surroundings));
    }

    /**
     * 新增Surroundings
     */
    @Override
    public int insertSurroundings(Surroundings surroundings) {
        return surroundingsMapper.insertSurroundings(surroundings);
    }

    /**
     * 通过id删除Surroundings
     */
    @Override
    public int deleteSurroundingsById(Long surroundingsId) {
        return surroundingsMapper.deleteSurroundingsById(surroundingsId);
    }

    /**
     * 通过id批量删除Surroundings
     */
    @Override
    public int deleteSurroundingsByIds(String surroundingsIds){
        return surroundingsMapper.deleteSurroundingsByIds(Convert.toStrArray(surroundingsIds));
    }

    /**
     * 修改Surroundings信息
     */
    @Override
    public int updateSurroundings(Surroundings surroundings) {
        return surroundingsMapper.updateSurroundings(surroundings);
    }

}

