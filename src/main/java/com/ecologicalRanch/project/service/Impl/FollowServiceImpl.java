package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Follow;
import com.ecologicalRanch.project.mapper.FollowMapper;
import com.ecologicalRanch.project.service.FollowService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2020-01-19 18:10:04'
 */
@Service
public class FollowServiceImpl implements FollowService {

    @Autowired
    private FollowMapper followMapper;


    /**
     * 查询Follow列表
     */

    @Override
    public List<Follow> selectFollowList(Follow follow,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->followMapper.selectFollowList(follow));
    }

    /**
     * 新增Follow
     */
    @Override
    public int insertFollow(Follow follow) {
        return followMapper.insertFollow(follow);
    }

    /**
     * 通过id删除Follow
     */
    @Override
    public int deleteFollow(Follow follow) {
        return followMapper.deleteFollow(follow);
    }

    /**
     * 通过id批量删除Follow
     */
    @Override
    public int deleteFollowByIds(String userIds){
        return followMapper.deleteFollowByIds(Convert.toStrArray(userIds));
    }



}
