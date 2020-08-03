package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Step;
import com.ecologicalRanch.project.entity.StepRult;
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

    @Override
     public List<Step> selectStepListNoPageHelper(Step step){
        return stepMapper.selectStepList(step);
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

    /**
     * 查询指定时间鸡的步数
     */
    @Override
    public int bySpecifying(Long livestockId, Long startTime, Long endTime){
            List<Step>  stepList= stepMapper.bySpecifying(livestockId,startTime,endTime);
            int count=0;
            for (Step s:stepList) {
            count =count + s.getStepNum();
            }
        return count;
    }


    @Override
    public List<StepRult> appoint(Long startTime,Long endTime,int appoint,Integer livestockId){
        return stepMapper.appoint(startTime,endTime, appoint, livestockId);
    }


    /**
     * 查询指定时间所有鸡平均的步数
     */
    @Override
    public int average(Long startTime, Long endTime){
        List<Step>  stepList= stepMapper.bySpecifying(null,startTime,endTime);
        int count=0;
        int aver=0;
        for (Step s:stepList) {
            count =count + s.getStepNum();
        }
        if (count==0){
            return  0 ;
        }
        aver=count/stepList.toArray().length;

        return aver;
    }
}
