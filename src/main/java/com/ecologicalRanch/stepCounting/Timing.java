package com.ecologicalRanch.stepCounting;

import com.ecologicalRanch.project.entity.Livestock;
import com.ecologicalRanch.project.entity.Step;
import com.ecologicalRanch.project.mapper.StepMapper;
import com.ecologicalRanch.project.service.CoordinatesService;
import com.ecologicalRanch.project.service.LivestockService;
import com.ecologicalRanch.project.service.StepService;
import com.ecologicalRanch.redis.entity.BluetoothRssiInfo;
import com.ecologicalRanch.redis.service.ISaveRssiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class Timing{

    @Autowired
    ISaveRssiService saveRssiService;
    @Autowired
    CoordinatesService coordinatesService;
    @Autowired
    StepService stepService;
    @Autowired
    StepMapper stepMapper;
    @Autowired
    LivestockService livestockService;

    /**
     * 记录鸡每8个小时中的运动数据
     */
    @Async
    @Scheduled(cron = "* * 0/8 * * ? ")
    public void pedometer() {
        List<Livestock> livestockList = livestockService.selectLivestockListNoPageHelper(new Livestock());
        if (livestockList.toArray().length != 0) {
            for (Livestock l : livestockList) {
                Step step = new Step();
                step.setLivestockId(l.getLivestockId());
                List<Step> stepList = stepService.selectStepListNoPageHelper(step);
                Date df = new Date();
                Timestamp ts = new Timestamp(df.getTime());
                step.setCreatTime(ts);
                if (stepList.toArray().length == 0) {
                    stepService.insertStep(step);
                } else {
                    Integer lastStepNum = stepMapper.selectRecentStep(l.getLivestockId()).getStepNum();
                    Integer thisStepNum = l.getStepNum();
                    Integer cuunt = thisStepNum - lastStepNum;
                    step.setStepNum(cuunt);
                    stepService.insertStep(step);
                }
            }
        }
    }

    @Scheduled(cron = "0/3 * * * * ?")
    public void proces(){
//        System.out.println("执行定时器");
        List<BluetoothRssiInfo> list = saveRssiService.getRssiList();

        if (list != null) {
            for (BluetoothRssiInfo bluetoothRssiInfo : list) {
//                System.out.println("蓝牙信息: 蓝牙Id：" + bluetoothRssiInfo.getBluetoothId());
                ProgramStart.AppThread(bluetoothRssiInfo);
                saveRssiService.delByBluetoothId(bluetoothRssiInfo.getBluetoothId());
//                ProgramStart.AppThread(coordinates.getBluetoothId().toString());
            }
        }
    }

  /*  @Scheduled(cron = "0/5 * * * * ?")
    public void proces(){
        if (saveRssiService.getRssiList() != null) {

            List<Coordinates> coordinatesList = coordinatesService.selectCoordinatesListNoPageHelper(new Coordinates());
            for (Coordinates coordinates : coordinatesList) {
               ProgramStart.AppThread(coordinates.getBluetoothId().toString());
            }
        }
    }*/
}


