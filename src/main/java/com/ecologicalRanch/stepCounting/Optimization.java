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

    public  double data( )
    {
        double n = K[R.length - 11];
        int g = 0,s=0;
        double Result;
        for(int i=(R.length-10);i<R.length;i++)
        {
            n =Math.abs( n - K[i]);
            if (n <= D)
                g++;
            else if (n >= 8)
                s++;
        }
        if (g >= 4 && Max(R) < 80)
        {
            Result= Average(K);
        }
        else if (g >= 4 && Max(R) > 80)
        {
            Result=  Max(K);
        }
        else if(s>=4&& Max(R) > 80)
        {
            Result=  Max(K);
        }
        else if (s >= 4 && Max(R)< 70)
        {
            Result=  Min(K);
        }
        else {
            if (Min(R) < 63 && Max(R) < 70)
                Result=  Min(K);
            else if (Min(R) < 65 && Max(R) < 70)
                Result=  Sort(K)[40];
            else if (Min(R) > 60 && Max(R) < 80)
                Result=  Sort(K)[60];
            else if (Min(R) > 70 && Max(R) < 80)
                Result=  Sort(K)[70];
            else if (Min(R) > 70 && Max(R) > 85)
                Result=  Max(K);
            else
                Result=  Average(K);

        }
        return Count (Result);
    }
    public double[] Sort(double[] d)
    {
        double s = 0;
        for (int i = 0; i < d.length - 1; i++)
            for (int j = i + 1; j < d.length; j++)
            {
                if (d[i] < d[j])
                {
                    s = d[j];
                    d[j] = d[i];
                    d[i] = s;
                }
            }
        return d;
    }
    public double Min(int[] d)
    {
        int min = d[0];
        for (int i = 1; i < d.length; i++)
        {
            if (min > d[i])
                min = d[i];
        }
        return min;
    }
    public double Max(int[] d)
    {
        int max = d[0];
        for (int i = 1; i < d.length; i++)
        {
            if (max > d[i])
                max = d[i];
        }
        return max;
    }
    public double Min(double[] d)
    {
        double min=d[0];
        for(int i=1;i<d.length;i++)
        {
            if (min > d[i])
                min = d[i];
        }
        return min;
    }
    public double Max(double[] d)
    {
        double max = d[0];
        for (int i = 1; i < d.length; i++)
        {
            if (max > d[i])
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
