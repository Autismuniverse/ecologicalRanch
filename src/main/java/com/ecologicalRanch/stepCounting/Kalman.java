package com.ecologicalRanch.stepCounting;

/**
 * �������˲��㷨
 * @author 15281
 *
 */
public class Kalman {
	private  double startValue;
    private  double kalmanGain;
    private  double A;
    private  double H;
    private  double Q;
    private  double R;
    private  double P;

    public Kalman(double q, double r)
    {//��ʼ��
          A=1;
          H=1;
          P=8;
          Q=q;
          R=r;
          startValue=60;
    }
    public double KalmanFilter( double value)
    {
        double predictValue = A* startValue;
        P = A*A*P + Q;
        kalmanGain = P*H / (P*H*H + R);
        startValue = predictValue + (value - predictValue)*kalmanGain;
        P = (1 - kalmanGain*H)*P;
        return  startValue;
    }

}
