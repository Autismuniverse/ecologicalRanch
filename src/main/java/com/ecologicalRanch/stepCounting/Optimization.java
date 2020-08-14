package com.ecologicalRanch.stepCounting;

import com.ecologicalRanch.config.ApplicationContextProvider;

public class Optimization {
    private Kalman kalman;
    private Calculation datasourcePro;
    public int[] R;
    public int D;
    public double[] K;

    public Optimization(int[] n)
    {
        this.datasourcePro= ApplicationContextProvider.getBean(Calculation.class);
        this.kalman = new Kalman(9, 100, Average(n));
        this.K = new double[n.length];
        this.R = n;

        this.D = datasourcePro.getDeviation();
        for (int i = 0; i < R.length; i++)
            K[1] = R[i];
    }
    private double Average(int[] d)
    {
        double average = 0;
        for (int i = 0; i < d.length; i++)
        {
            average += d[i];
        }
        return average / d.length;
    }

    public int BrokenlLineAnalysis(int[] n)
    {
        int[] d = new int[20];
        int m=n[n.length-1];
        for(int i=0;i<20;i++)
        {
            d[i] = Math.abs(m - (n[n.length - 2 - i]));
            m = n[n.length - 2 - i];
        }
        d=Sort(d);
        return d[12];
    }
    public double Data()
    {
        int d = BrokenlLineAnalysis(R);
        R = Sort(R);
        double Result;
        switch (d)
        {
            case 7 : {
                double max = Max(K);
                if (R[70] > 80)
                {
                    double max1 = Max(R);

                    Result = max + (max1 - max) * 0.15;
                }
                else
                {
                    double min = Min(R);
                    Result = min + (max - min) * 0.9;
                }
            } ; break;
            case 8:
            {
                double max = Max(K);
                if (R[70] > 80)
                {
                    double max1 = Max(R);

                    Result = max + (max1 - max) * 0.30;
                }
                else
                {
                    double min = Min(R);
                    Result = min + (max - min) * 0.75;
                }
            }; break;
            case 9 :
            {
                double max = Max(K);
                if (R[70] > 80)
                {
                    double max1 = Max(R);

                    Result= max + (max1 - max) * 0.45;
                }
                else
                {
                    double min = Min(R);
                    Result = min + (max - min) * 0.60;
                }
            }; break;
            case 10:
            {

                double max = Max(K);
                if (R[70] > 80)
                {
                    double max1 = Max(R);

                    Result = max + (max1 - max) * 0.60;
                }
                else
                {
                    double min = Min(R);
                    Result = min + (max - min) * 0.45;
                }
            }; break;
            case 11:
            {

                double max = Max(K);
                if (R[70] > 80)
                {
                    double max1 = Max(R);

                    Result = max + (max1 - max) * 0.75;
                }
                else
                {
                    double min = Min(R);
                    Result = min + (max - min) * 0.30;
                }
            }; break;
            case 12:
            {

                double max = Max(K);
                if (R[70] > 80)
                {
                    double max1 = Max(R);

                    Result = max + (max1 - max) * 0.90;
                }
                else
                {
                    double min = Min(R);
                    Result = min + (max - min) * 0.15;
                }
            }; break;
            default: {
                if (Max(R) > 82 && d > 12)
                    Result = Max(R);
                else if (Min(R) < 62 && d < 8)
                    Result = Average(K);
                else
                    Result = Max(K);
            };break;
        }
        return Count (Result);
    }
//    public double[] Sort(double[] d)
//    {
//
//        double s = 0;
//        for (int i = 0; i < d.length - 1; i++)
//            for (int j = i + 1; j < d.length; j++)
//            {
//                if (d[i] < d[j])
//                {
//                    s = d[j];
//                    d[j] = d[i];
//                    d[i] = s;
//                }
//            }
//        return d;
//    }
    public int[] Sort(int[] n)
    {

        int s = 0;
        for ( int i = 0; i < n.length - 1; i++)
            for (int j = i + 1; j < n.length; j++)
            {
                if (n[i] < n[j])
                {
                    s = n[j];
                    n[j] = n[i];
                    n[i] = s;
                }
            }
        return n;
    }
    public int Min(int[] d)
    {
        int min = d[0];
        for (int i = 1; i < d.length; i++)
        {
            if (min > d[i])
                min = d[i];
        }
        return min;
    }
    public int Max(int[] d)
    {
        int max = d[0];
        for (int i = 1; i < d.length; i++)
        {
            if (max < d[i])
                max = d[i];
        }
        return max;
    }
//    public double Min(double[] d)
//    {
//        double min=d[0];
//        for(int i=1;i<d.length;i++)
//        {
//            if (min > d[i])
//                min = d[i];
//        }
//        return min;
//    }
    public double Max(double[] d)
    {
        double max = d[0];
        for (int i = 1; i < d.length; i++)
        {
            if (max < d[i])
                max = d[i];
        }
        return max;
    }
    public double Average(double[] d)
    {
        double average = 0;
        for (int i = 0; i < d.length; i++)
        {
            average += d[i];
        }
        return average / d.length;
    }
    /**
     * 通过RSSI计算距离
     * @param rssi
     * @return 距离
     */
    private double Count(double rssi) {
        double n;
        n = Math.abs(rssi);
        n = ((n - datasourcePro.getCalibration()) / (10 * datasourcePro.getEnvironmentalFactor()));
        n =  Math.pow(10, n);
        n += 0.005;
        n *= 100;
        n = (int) n;
        n = n / 100;
        return n;
    }
}
