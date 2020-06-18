package com.ecologicalRanch.stepCounting;

import com.ecologicalRanch.project.service.CoordinatesService;
import com.ecologicalRanch.redis.entity.BluetoothRssiInfo;
import com.ecologicalRanch.redis.service.ISaveRssiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Timing{

    @Autowired
    ISaveRssiService saveRssiService;
    @Autowired
    CoordinatesService coordinatesService;

    @Scheduled(cron = "0/3 * * * * ?")
    public void proces(){
        System.out.println("执行定时器");
        List<BluetoothRssiInfo> list = saveRssiService.getRssiList();

        if (list != null) {
            for (BluetoothRssiInfo bluetoothRssiInfo : list) {
                System.out.println("蓝牙信息: 蓝牙Id：" + bluetoothRssiInfo.getBluetoothId());
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


