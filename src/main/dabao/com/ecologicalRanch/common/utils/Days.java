package com.ecologicalRanch.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class Days {
    public static int differentDays(String bdate, String edate) {
        try {
            //根据日期格式类型进行转化
            Date date1 = new SimpleDateFormat("yyyyMMdd").parse(bdate);
            Date date2 = new SimpleDateFormat("yyyyMMdd").parse(edate);
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(date1);

            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(date2);
            int day1 = cal1.get(Calendar.DAY_OF_YEAR);
            int day2 = cal2.get(Calendar.DAY_OF_YEAR);

            int year1 = cal1.get(Calendar.YEAR);
            int year2 = cal2.get(Calendar.YEAR);
            if (year1 != year2) {
                int timeDistance = 0;
                for (int i = year1; i < year2; i++) {
                    //闰年
                    if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {
                        timeDistance += 366;
                    } else {
                        timeDistance += 365;
                    }
                }
                return timeDistance + (day2 - day1);
            } else {
                System.out.println("判断day2 - day1 : " + (day2 - day1));
                return day2 - day1 + 1;
            }
        } catch (Exception ex) {
            System.out.println("日期转换出错！" +ex);
            return 0;
        }
    }
}