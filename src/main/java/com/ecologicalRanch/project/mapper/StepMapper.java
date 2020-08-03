package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Step;
import com.ecologicalRanch.project.entity.StepRult;

import java.util.List;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-04-02 16:07:03'
 */
public interface StepMapper {

    /**
     * 查询Step列表
     * @param step 查询对象
     * @return 查询列表
     */
    List<Step> selectStepList(Step step);



    /**
     * 通过Id查询 Step
     * @param stepNumId 查询Id
     * @return 查询对象
     */
    Step selectStepById(Long stepNumId);

    /**
     * 查询上次记录的数据
     * @param step
     * @return 查询对象
     */
    Step selectLastrecorded(Step step);

    /**
     * 查询最近一次数据
     * @return
     */
    Step selectRecentStep(Long livestockId);

    /**
     * 查询指定时间某只鸡的数据列表
     * @return
     */
    List<Step> bySpecifying(Long livestockId, Long startTime,Long endTime);


    /**
     * 按照格式查询指定时间某只鸡的数据列表
     * @return
     */
    List<StepRult> appoint(Long startTime,Long endTime,Integer appoint,Integer livestockId);


    /**
     * 新增Step
     * @param step 新增对象
     * @return 插入行数
     */
    int insertStep(Step step);

    /**
     * 修改Step信息
     * @param  step 用户对象
     * @return 更新行数
     */
    int updateStep(Step step);

    /**
     * 通过id删除Step
     * @param stepNumId 删除id
     * @return 删除行数
     */
    int deleteStepById(Long stepNumId);

    /**
     * 通过id批量删除Step
     * @param stepNumIds 删除ids
     * @return 删除行数
     */
    int deleteStepByIds(String[] stepNumIds);



}
