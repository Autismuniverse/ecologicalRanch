package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Field;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-30 14:31:08'
 */
public interface FieldMapper {

    /**
     * 查询Field列表
     * @param field 查询对象
     * @return 查询列表
     */
    List<Field> selectFieldList(Field field);

    /**
     * 通过Id查询 Field
     * @param fieldId 查询Id
     * @return 查询对象
     */
    Field selectFieldById(Long fieldId);

    /**
     * 新增Field
     * @param field 新增对象
     * @return 插入行数
     */
    int insertField(Field field);

    /**
     * 修改Field信息
     * @param  field 用户对象
     * @return 更新行数
     */
    int updateField(Field field);

    /**
     * 通过id删除Field
     * @param fieldId 删除id
     * @return 删除行数
     */
    int deleteFieldById(Long fieldId);

    /**
     * 通过id批量删除Field
     * @param fieldIds 删除ids
     * @return 删除行数
     */
    int deleteFieldByIds(String[] fieldIds);

    /**
     * 通过AdminId查询 Field
     * @param Adminid 查询
     * @return 查询对象
     */
    List<Field> selectFieldByAdminId(Long adminid);

}
