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
//    public int getCalibration() {
//        return Calibration;
//    }
//    public void setCalibration(int Calibration) {
//        this.Calibration = Calibration;
//    }
//    public double getEnvironmentalFactor() {
//        return EnvironmentalFactor;
//    }
//    public void setEnvironmentalFactor(double EnvironmentalFactor) {
//        this.EnvironmentalFactor = EnvironmentalFactor;
//    }
//    public int getDeviation() {
//        return Deviation;
//    }
//    public void setDeviation(int Deviation) {
//        this.Deviation = Deviation;
//    }
//    public int getError() {
//        return Error;
//    }
//    public void setError(int Error) {
//        this.Error = Error;
//    }
//    public double getVarianc() {
//        return Varianc;
//    }
//    public void setVarianc(double Varianc) {
//        this.Varianc = Varianc;
//    }
//    public double getNoiseVariance() {
//        return NoiseVariance;
//    }
//    public void setNoiseVariance(double NoiseVariance) {
//        this.NoiseVariance = NoiseVariance;
//    }

}
