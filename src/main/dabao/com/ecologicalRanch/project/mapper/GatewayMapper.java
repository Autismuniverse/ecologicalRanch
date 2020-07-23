package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Gateway;

import java.util.List;

/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-27 14:54:24'
 */
public interface GatewayMapper {

    /**
     * 查询Gateway列表
     * @param gateway 查询对象
     * @return 查询列表
     */
    List<Gateway> selectGatewayList(Gateway gateway);

    /**
     * 通过Id查询 Gateway
     * @param gatewayId 查询Id
     * @return 查询对象
     */
    Gateway selectGatewayByMac(Gateway gateway);

    /**
     * 新增Gateway
     * @param gateway 新增对象
     * @return 插入行数
     */
    int insertGateway(Gateway gateway);

    /**
     * 修改Gateway信息
     * @param  gateway 用户对象
     * @return 更新行数
     */
    int updateGateway(Gateway gateway);

    /**
     * 通过id删除Gateway
     * @param gatewayId 删除id
     * @return 删除行数
     */
    int deleteGatewayById(Long gatewayId);

    /**
     * 通过id批量删除Gateway
     * @param gatewayIds 删除ids
     * @return 删除行数
     */
    int deleteGatewayByIds(String[] gatewayIds);

}
