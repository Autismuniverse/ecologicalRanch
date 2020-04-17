package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Field;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-30 14:31:08'
 */
public interface FieldService {

    /**
     * 查询Field列表
     */
    List<Field> selectFieldList(Field field, int pageNum, int pageSize);

    /**
     * 通过Id查询 Field
     */
    Field selectFieldById(Long fieldId);

    /**
     * 新增Field
     */
    int insertField(Field field);

    /**
     * 通过id删除Field
     */
    int deleteFieldById(Long fieldId);

    /**
     * 通过id批量删除Field
     */
    int deleteFieldByIds(String fieldIds);

    /**
     * 修改Field信息
     */
    int updateField(Field field);

    /**
     * 通过adminId查询 Field
     */
    List<Field> selectFieldByAdminId(Long adminId);
}