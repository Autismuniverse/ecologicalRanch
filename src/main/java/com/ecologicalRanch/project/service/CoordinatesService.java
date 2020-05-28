package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Coordinates;

import java.util.List;


/**
 *
 *
 * @author xxxfredyang
 * @date '2020-05-28 14:32:02'
 */
public interface CoordinatesService {

    /**
     * 查询Coordinates列表
     */
    List<Coordinates> selectCoordinatesList(Coordinates coordinates, int pageNum, int pageSize);

    /**
     * 通过Id查询 Coordinates
     */
    Coordinates selectCoordinatesById(Long bluetoothId);

    /**
     * 新增Coordinates
     */
    int insertCoordinates(Coordinates coordinates);

    /**
     * 通过id删除Coordinates
     */
    int deleteCoordinatesById(Long bluetoothId);

    /**
     * 通过id批量删除Coordinates
     */
    int deleteCoordinatesByIds(String bluetoothIds);

    /**
     * 修改Coordinates信息
     */
    int updateCoordinates(Coordinates coordinates);

}
