package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Coordinates;

import java.util.List;


/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-28 14:32:02'
 */
public interface CoordinatesMapper {

    /**
     * 查询Coordinates列表
     * @param coordinates 查询对象
     * @return 查询列表
     */
    List<Coordinates> selectCoordinatesList(Coordinates coordinates);

    /**
     * 通过Id查询 Coordinates
     * @param bluetoothId 查询Id
     * @return 查询对象
     */
    Coordinates selectCoordinatesById(String bluetoothId);

    /**
     * 通过Id查询 Coordinates
     * @param bluetoothMac 查询Id
     * @return 查询对象
     */
    Coordinates selectCoordinatesByMac(String bluetoothMac);

    /**
     * 新增Coordinates
     * @param coordinates 新增对象
     * @return 插入行数
     */
    int insertCoordinates(Coordinates coordinates);

    /**
     * 修改Coordinates信息
     * @param  coordinates 用户对象
     * @return 更新行数
     */
    int updateCoordinates(Coordinates coordinates);

    /**
     * 通过id删除Coordinates
     * @param bluetoothId 删除id
     * @return 删除行数
     */
    int deleteCoordinatesById(String bluetoothId);

    /**
     * 通过id批量删除Coordinates
     * @param bluetoothIds 删除ids
     * @return 删除行数
     */
    int deleteCoordinatesByIds(String[] bluetoothIds);

}

