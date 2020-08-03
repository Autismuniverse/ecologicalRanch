package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Gateway;

import java.util.List;


/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-27 14:54:24'
 */
public interface GatewayService {

    /**
     * 查询Gateway列表
     */
    List<Gateway> selectGatewayList(Gateway gateway, int pageNum, int pageSize);

    /**
     * 通过Id查询 Gateway
     */
    String selectGatewayByMac(Gateway gateway);

    /**
     * 新增Gateway
     */
    int insertGateway(Gateway gateway);

    /**
     * 通过id删除Gateway
     */
    int deleteGatewayById(Long gatewayId);

    /**
     * 通过id批量删除Gateway
     */
    int deleteGatewayByIds(String gatewayIds);

    /**
     * 修改Gateway信息
     */
    int updateGateway(Gateway gateway);

}
