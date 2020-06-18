package com.ecologicalRanch.redis.utils;

import java.awt.*;

public class PointUtil {
    public static Point stringToPoint(String coordinate){
        String[] f = coordinate.split(",");
        return new Point(Integer.parseInt(f[0]),Integer.parseInt(f[1]));
    }

    public static String toString(Point point){
        return new Double(point.getX()).intValue() + "," + new Double(point.getY()).intValue();
    }
}
