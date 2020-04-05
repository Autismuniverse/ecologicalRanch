package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Step;
import com.ecologicalRanch.project.mapper.StepMapper;
import com.ecologicalRanch.project.service.StepService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-04-04 14:26:28'
 */
@Service
public class StepServiceImpl implements StepService {

    @Autowired
    private StepMapper stepMapper;

    /**
     * 通过Id查询 Step
     */
    @Override
    public Step selectStepById(Long stepNumId) {
        return stepMapper.selectStepById(stepNumId);
    }

    /**
     * 查询Step列表
     */

    @Override
    public List<Step> selectStepList(Step step, int pageNum, int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->stepMapper.selectStepList(step));
    }

    /**
     * 新增Step
     */
    @Override
    public int insertStep(Step step) {
        return stepMapper.insertStep(step);
    }

    /**
     * 通过id删除Step
     */
    @Override
    public int deleteStepById(Long stepNumId) {
        return stepMapper.deleteStepById(stepNumId);
    }

    /**
     * 通过id批量删除Step
     */
    @Override
    public int deleteStepByIds(String stepNumIds){
        return stepMapper.deleteStepByIds(Convert.toStrArray(stepNumIds));
    }

    /**
     * 修改Step信息
     */
    @Override
    public int updateStep(Step step) {
        return stepMapper.updateStep(step);
    }

}
