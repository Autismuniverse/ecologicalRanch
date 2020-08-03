package com.ecologicalRanch.project.service.Impl;

import com.ecologicalRanch.common.utils.text.Convert;
import com.ecologicalRanch.project.entity.Camera;
import com.ecologicalRanch.project.mapper.CameraMapper;
import com.ecologicalRanch.project.service.CameraService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author XXXFredYang
 * @date '2020-07-20 16:11:14'
 */
@Service
public class CameraServiceImpl implements CameraService {

    @Autowired
    private CameraMapper cameraMapper;

    /**
     * 通过Id查询 Camera
     */
    @Override
    public Camera selectCameraById(Integer cameraId) {
        return cameraMapper.selectCameraById(cameraId);
    }

    /**
     * 查询Camera列表
     */

    @Override
    public List<Camera> selectCameraList(Camera camera,int pageNum,int pageSize){
        return  PageHelper.startPage(pageNum,pageSize).doSelectPage(()->cameraMapper.selectCameraList(camera));
    }

    @Override
    public List<Camera> selectCameraListNoPageHelper(Camera camera){
        return cameraMapper.selectCameraList(camera);
    }

    /**
     * 新增Camera
     */
    @Override
    public int insertCamera(Camera camera) {
        return cameraMapper.insertCamera(camera);
    }

    /**
     * 通过id删除Camera
     */
    @Override
    public int deleteCameraById(Integer cameraId) {
        return cameraMapper.deleteCameraById(cameraId);
    }

    /**
     * 通过id批量删除Camera
     */
    @Override
    public int deleteCameraByIds(String cameraIds){
        return cameraMapper.deleteCameraByIds(Convert.toStrArray(cameraIds));
    }

    /**
     * 修改Camera信息
     */
    @Override
    public int updateCamera(Camera camera) {
        return cameraMapper.updateCamera(camera);
    }

}
