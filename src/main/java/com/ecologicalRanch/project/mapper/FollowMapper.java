package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Follow;

import java.util.List;

/**
 *
 *
 * @author u-fun
 * @date '2020-01-19 18:10:04'
 */
public interface FollowMapper {

    /**
     * 查询Follow列表
     * @param follow 查询对象
     * @return 查询列表
     */
    List<Follow> selectFollowList(Follow follow);



    /**
     * 新增Follow
     * @param follow 新增对象
     * @return 插入行数
     */
    int insertFollow(Follow follow);


    /**
     * 删除Follow
     * @param follow 用户对象
     * @return 删除行数
     */
    int deleteFollow(Follow follow);

    /**
     * 通过id批量删除Follow
     * @param userIds 删除ids
     * @return 删除行数
     */
    int deleteFollowByIds(String[] userIds);

}

