package com.ecologicalRanch.stepCounting;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties( prefix = "calculation")
@Component
@Data
public class Calculation {
    private int Calibration;
    private double EnvironmentalFactor;
    private int Deviation;
    private int Error;
    private double Varianc;
    private double NoiseVariance;


}
