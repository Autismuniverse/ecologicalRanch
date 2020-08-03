package com.ecologicalRanch.project.entity;

import lombok.Data;

import java.awt.*;
import java.sql.Timestamp;

@Data
public class RssiSave {

    private int[] MacA;
    private int[] MacB;
    private int[] MacC;
    private String blueToothId;
    private int MacAFromBlue;
    private int MacBFromBlue;
    private int MacCFromBlue;

    private Timestamp timestamp;

    private Point point;

}
