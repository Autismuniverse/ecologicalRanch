package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Coordinates;
import com.ecologicalRanch.project.mapper.CoordinatesMapper;
import com.ecologicalRanch.project.service.CoordinatesService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /**
     * 新增Coordinates
     */
    @Override
    public int insertCoordinates(Coordinates coordinates) {
        return coordinatesMapper.insertCoordinates(coordinates);
    }

    /**
     * 通过id删除Coordinates
     */
    @Override
    public int deleteCoordinatesById(Long bluetoothId) {
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
        return coordinatesMapper.updateCoordinates(coordinates);
    }

}
