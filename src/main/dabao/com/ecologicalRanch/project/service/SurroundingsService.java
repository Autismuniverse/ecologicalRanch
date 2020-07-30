package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Surroundings;

import java.util.List;



/**
 *
 *
 * @author XXXFredYang
 * @date '2020-07-29 15:43:26'
 */
public interface SurroundingsService {

    /**
     * 查询Surroundings列表
     */
    List<Surroundings> selectSurroundingsList(Surroundings surroundings, int pageNum, int pageSize);

    /**
     * 通过Id查询 Surroundings
     */
    Surroundings selectSurroundingsByFieldId(Integer fieldId);

    /**
     * 新增Surroundings
     */
    int insertSurroundings(Surroundings surroundings);

    /**
     * 通过id删除Surroundings
     */
    int deleteSurroundingsById(Long surroundingsId);

    /**
     * 通过id批量删除Surroundings
     */
    int deleteSurroundingsByIds(String surroundingsIds);

    /**
     * 修改Surroundings信息
     */
    int updateSurroundings(Surroundings surroundings);

}
