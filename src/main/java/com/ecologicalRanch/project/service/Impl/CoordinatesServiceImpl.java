package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Coordinates;
import com.ecologicalRanch.project.entity.Livestock;
import com.ecologicalRanch.project.mapper.CoordinatesMapper;
import com.ecologicalRanch.project.mapper.LivestockMapper;
import com.ecologicalRanch.project.service.CoordinatesService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-28 14:32:02'
 */
@Service
public class CoordinatesServiceImpl implements CoordinatesService {

    @Autowired
    private CoordinatesMapper coordinatesMapper;
    @Autowired
    private TotalBluetoothServiceImpl totalBluetoothService;
    @Autowired
    private LivestockMapper livestockMapper;

    /**
     * 通过Id查询 Coordinates
     */
    @Override
    public Coordinates selectCoordinatesById(String bluetoothId) {
        return coordinatesMapper.selectCoordinatesById(bluetoothId);
    }

    /**
     * 通过Mac查询 Coordinates
     */
    @Override
    public Coordinates selectCoordinatesByMac(String bluetoothMac) {
        return coordinatesMapper.selectCoordinatesByMac(bluetoothMac);

    }

    /**
     * 查询Coordinates列表
     */

    @Override
    public List<Coordinates> selectCoordinatesList(Coordinates coordinates,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->coordinatesMapper.selectCoordinatesList(coordinates));
    }

    @Override
    public List<Coordinates> selectCoordinatesListNoPageHelper(Coordinates coordinates){
        return  coordinatesMapper.selectCoordinatesList(coordinates);
    }

    public List<Coordinates> selectAbleCoordinatesList(Coordinates coordinates){
        Livestock livestock = new Livestock();
        livestock.setFieldId(coordinates.getFieldId());
        List<Livestock> livestockList =  livestockMapper.selectLivestockList(livestock);
        List<Coordinates> coordinates1 = coordinatesMapper.selectCoordinatesList(coordinates);
        List<Coordinates> coordinates2 = new ArrayList<>();
        if(livestockList != null){
        //判断使用过的蓝牙
        for (Coordinates c:coordinates1) {
            for (Livestock l:livestockList){
                if(c.getBluetoothId().equals(l.getBluetoothId())){
                    coordinates2.add(c);
                }
            }
            }
        //在List1中 去除相同的蓝牙
        coordinates1.removeAll(coordinates2);
        return coordinates1;
        }
        else return coordinates1;


    }

    /**
     * 新增Coordinates
     */
    @Override
    public int insertCoordinates(Coordinates coordinates) {
//        if(coordinatesMapper.selectCoordinatesByMac(coordinates.getBluetoothMac()).getBluetoothMac()==coordinates.getBluetoothMac())
//            return 0;
//        TotalBluetooth totalBluetooth =new TotalBluetooth();
//        totalBluetooth.setFieldId(coordinates.getFieldId());
//        totalBluetoothService.updateTotalBluetooth(totalBluetooth);
        return coordinatesMapper.insertCoordinates(coordinates);
    }

    /**
     * 通过id删除Coordinates
     */
    @Override
    public int deleteCoordinatesById(String bluetoothId) {
        return coordinatesMapper.deleteCoordinatesById(bluetoothId);
    }

    /**
     * 通过id批量删除Coordinates
     */
    @Override
    public int deleteCoordinatesByIds(String bluetoothIds){
        return coordinatesMapper.deleteCoordinatesByIds(Convert.toStrArray(bluetoothIds));
    }

    /**
     * 修改Coordinates信息
     */
    @Override
    public int updateCoordinates(Coordinates coordinates) {
//        System.out.println(coordinates);
        return coordinatesMapper.updateCoordinates(coordinates);
    }

}
