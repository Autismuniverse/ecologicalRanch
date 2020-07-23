package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Follow;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2020-01-19 18:10:04'
 */
public interface FollowService {

    /**
     * 查询Follow列表
     */
    List<Follow> selectFollowList(Follow follow, int pageNum, int pageSize);



    /**
     * 新增Follow
     */
    int insertFollow(Follow follow);

    /**
     * 删除Follow
     */
    int deleteFollow(Follow follow);

    /**
     * 通过id批量删除Follow
     */
    int deleteFollowByIds(String userIds);



}
