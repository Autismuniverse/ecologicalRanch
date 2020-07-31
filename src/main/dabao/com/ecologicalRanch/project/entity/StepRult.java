package com.ecologicalRanch.project.entity;

import lombok.Data;

import java.sql.Timestamp;
@Data

public class StepRult {
    /**
     * 开始时间
     */
    private Timestamp startTime;
    /**
     * 结束时间
     */
    private Timestamp endTime;
    /**
     * 时间组
     */
    private int timeSanp;
    /**
     * 鸡id
     */
    private Integer livestockId;
    /**
     * 时间段内步数
     */
    private Integer totalStp;

    private Integer appoint;
}
