package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Surroundings;

import java.util.List;

/**
 *
 *
 * @author XXXFredYang
 * @date '2020-07-29 15:43:26'
 */
public interface SurroundingsMapper {

    /**
     * 查询Surroundings列表
     * @param surroundings 查询对象
     * @return 查询列表
     */
    List<Surroundings> selectSurroundingsList(Surroundings surroundings);

    /**
     * 通过Id查询 Surroundings
     * @param fieldId 查询Id
     * @return 查询对象
     */
    Surroundings selectSurroundingsByFieldId(Integer fieldId);

    /**
     * 新增Surroundings
     * @param surroundings 新增对象
     * @return 插入行数
     */
    int insertSurroundings(Surroundings surroundings);

    /**
     * 修改Surroundings信息
     * @param  surroundings 用户对象
     * @return 更新行数
     */
    int updateSurroundings(Surroundings surroundings);

    /**
     * 通过id删除Surroundings
     * @param surroundingsId 删除id
     * @return 删除行数
     */
    int deleteSurroundingsById(Long surroundingsId);

    /**
     * 通过id批量删除Surroundings
     * @param surroundingsIds 删除ids
     * @return 删除行数
     */
    int deleteSurroundingsByIds(String[] surroundingsIds);

}
