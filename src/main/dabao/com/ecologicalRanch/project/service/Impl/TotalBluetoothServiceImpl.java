package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.TotalBluetooth;
import com.ecologicalRanch.project.mapper.TotalBluetoothMapper;
import com.ecologicalRanch.project.service.TotalBluetoothService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



/**
 *
 *
 * @author xxxfredyang
 * @date '2020-06-26 19:40:07'
 */
@Service
public class TotalBluetoothServiceImpl implements TotalBluetoothService {

    @Autowired
    private TotalBluetoothMapper totalBluetoothMapper;

    /**
     * 通过Id查询 TotalBluetooth
     */
    @Override
    public TotalBluetooth selectTotalBluetoothById(String TotalBluetoothId) {
        return totalBluetoothMapper.selectTotalBluetoothById(TotalBluetoothId);
    }

    /**
     * 查询TotalBluetooth列表
     */

    @Override
    public List<TotalBluetooth> selectTotalBluetoothList(TotalBluetooth TotalBluetooth,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->totalBluetoothMapper.selectTotalBluetoothList(TotalBluetooth));
    }

    @Override
    public List<TotalBluetooth> selectTotalBluetoothListNoPageHelper(TotalBluetooth TotalBluetooth){
        return  totalBluetoothMapper.selectTotalBluetoothList(TotalBluetooth);
    }

    /**
     * 新增TotalBluetooth
     */
    @Override
    public int insertTotalBluetooth(TotalBluetooth TotalBluetooth) {
        return totalBluetoothMapper.insertTotalBluetooth(TotalBluetooth);
    }

    /**
     * 通过id删除TotalBluetooth
     */
    @Override
    public int deleteTotalBluetoothById(String TotalBluetoothId) {
        return totalBluetoothMapper.deleteTotalBluetoothById(TotalBluetoothId);
    }

    /**
     * 通过id批量删除TotalBluetooth
     */
    @Override
    public int deleteTotalBluetoothByIds(String TotalBluetoothIds){
        return totalBluetoothMapper.deleteTotalBluetoothByIds(Convert.toStrArray(TotalBluetoothIds));
    }

    /**
     * 修改TotalBluetooth信息
     */
    @Override
    public int updateTotalBluetooth(TotalBluetooth TotalBluetooth) {
        return totalBluetoothMapper.updateTotalBluetooth(TotalBluetooth);
    }

}

