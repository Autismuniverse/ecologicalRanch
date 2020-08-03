package com.ecologicalRanch.project.mapper;

import com.ecologicalRanch.project.entity.Camera;

import java.util.List;

/**
 *
 *
 * @author XXXFredYang
 * @date '2020-07-20 16:11:14'
 */
public interface CameraMapper {

    /**
     * 查询Camera列表
     * @param camera 查询对象
     * @return 查询列表
     */
    List<Camera> selectCameraList(Camera camera);

    /**
     * 通过Id查询 Camera
     * @param cameraId 查询Id
     * @return 查询对象
     */
    Camera selectCameraById(Integer cameraId);

    /**
     * 新增Camera
     * @param camera 新增对象
     * @return 插入行数
     */
    int insertCamera(Camera camera);

    /**
     * 修改Camera信息
     * @param  camera 用户对象
     * @return 更新行数
     */
    int updateCamera(Camera camera);

    /**
     * 通过id删除Camera
     * @param cameraId 删除id
     * @return 删除行数
     */
    int deleteCameraById(Integer cameraId);

    /**
     * 通过id批量删除Camera
     * @param cameraIds 删除ids
     * @return 删除行数
     */
    int deleteCameraByIds(String[] cameraIds);

}
