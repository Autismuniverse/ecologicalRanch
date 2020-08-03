package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Gateway;
import com.ecologicalRanch.project.mapper.GatewayMapper;
import com.ecologicalRanch.project.service.GatewayService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-27 14:54:24'
 */
@Service
public class GatewayServiceImpl implements GatewayService {

    @Autowired
    private GatewayMapper gatewayMapper;

    /**
     * 通过Id查询 Gateway
     */
    @Override
    public String selectGatewayByMac(Gateway gateway) {
        Gateway gateway1 = gatewayMapper.selectGatewayByMac(gateway);
        return gateway1.getCoordinateX() + "," + gateway1.getCoordinateY();
    }

    /**
     * 查询Gateway列表
     */

    @Override
    public List<Gateway> selectGatewayList(Gateway gateway,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->gatewayMapper.selectGatewayList(gateway));
    }

    /**
     * 新增Gateway
     */
    @Override
    public int insertGateway(Gateway gateway) {
        return gatewayMapper.insertGateway(gateway);
    }

    /**
     * 通过id删除Gateway
     */
    @Override
    public int deleteGatewayById(Long gatewayId) {
        return gatewayMapper.deleteGatewayById(gatewayId);
    }

    /**
     * 通过id批量删除Gateway
     */
    @Override
    public int deleteGatewayByIds(String gatewayIds){
        return gatewayMapper.deleteGatewayByIds(Convert.toStrArray(gatewayIds));
    }

    /**
     * 修改Gateway信息
     */
    @Override
    public int updateGateway(Gateway gateway) {
        return gatewayMapper.updateGateway(gateway);
    }

}

