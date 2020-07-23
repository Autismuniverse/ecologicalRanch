package com.ecologicalRanch.project.service;

import com.ecologicalRanch.project.entity.Camera;

import java.util.List;

/**
 *
 *
 * @author XXXFredYang
 * @date '2020-07-20 16:11:14'
 */
public interface CameraService {

    /**
     * 查询Camera列表
     */
    List<Camera> selectCameraList(Camera camera, int pageNum, int pageSize);

    /**
     * 通过Id查询 Camera
     */
    Camera selectCameraById(Integer cameraId);

    /**
     * 新增Camera
     */
    int insertCamera(Camera camera);

    /**
     * 通过id删除Camera
     */
    int deleteCameraById(Integer cameraId);

    /**
     * 通过id批量删除Camera
     */
    int deleteCameraByIds(String cameraIds);

    /**
     * 修改Camera信息
     */
    int updateCamera(Camera camera);

}
