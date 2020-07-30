package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Step;

import java.sql.Timestamp;
import java.util.List;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-04-04 14:26:28'
 */
public interface StepService {

    /**
     * 查询Step列表
     */
    List<Step> selectStepList(Step step, int pageNum, int pageSize);


    /**
     * 查询Step列表
     */
    List<Step> selectStepListNoPageHelper(Step step);

    /**
     * 通过Id查询 Step
     */
    Step selectStepById(Long stepNumId);

    /**
     * 新增Step
     */
    int insertStep(Step step);

    /**
     * 通过id删除Step
     */
    int deleteStepById(Long stepNumId);

    /**
     * 通过id批量删除Step
     */
    int deleteStepByIds(String stepNumIds);

    /**
     * 修改Step信息
     */
    int updateStep(Step step);

    /**
     * 查询指定时间鸡的步数
     */
     int bySpecifying(Long livestockId, Timestamp startTime, Timestamp endTime);

    /**
     * 查询指定时间所有鸡平均的步数
     */
     int average(Timestamp startTime, Timestamp endTime);

}