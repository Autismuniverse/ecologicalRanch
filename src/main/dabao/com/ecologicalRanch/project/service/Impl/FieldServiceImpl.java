package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.project.entity.Field;
import com.ecologicalRanch.project.mapper.FieldMapper;
import com.ecologicalRanch.project.service.FieldService;
import com.ecologicalRanch.utils2.Convert;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2019-12-30 14:31:08'
 */
@Service
public class FieldServiceImpl implements FieldService {

    @Autowired
    private FieldMapper fieldMapper;

    /**
     * 通过Id查询 Field
     */
    @Override
    public Field selectFieldById(Long fieldId) {
        return fieldMapper.selectFieldById(fieldId);
    }

    /**
     * 查询Field列表
     */

    @Override
    public List<Field> selectFieldList(Field field,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->fieldMapper.selectFieldList(field));
    }

    /**
     * 新增Field
     */
    @Override
    public int insertField(Field field) {
        return fieldMapper.insertField(field);
    }

    /**
     * 通过id删除Field
     */
    @Override
    public int deleteFieldById(Long fieldId) {
        return fieldMapper.deleteFieldById(fieldId);
    }

    /**
     * 通过id批量删除Field
     */
    @Override
    public int deleteFieldByIds(String fieldIds){
        return fieldMapper.deleteFieldByIds(Convert.toStrArray(fieldIds));
    }

    /**
     * 修改Field信息
     */
    @Override
    public int updateField(Field field) {
        return fieldMapper.updateField(field);
    }

    /**
     * 通过adminId查询 Field
     */
    @Override
    public  List<Field> selectFieldByAdminId(Long adminId) {
        return fieldMapper.selectFieldByAdminId(adminId);
    }

    /**
     * 通过FieldIds查询 Field
     */
    @Override
    public  List<Field> selectFieldByFieldIds(String fieldIds) {
//        System.out.println(fieldMapper.selectFieldByFieldIds(Convert.toStrArray(fieldIds)));
        return fieldMapper.selectFieldByFieldIds(Convert.toStrArray(fieldIds));
    }

}
