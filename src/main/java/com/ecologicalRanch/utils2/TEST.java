package com.ecologicalRanch.utils2;

public class TEST {


        public static void main(String[] args) {
            String str = "\"code\":\"043YpHyC1zNQr70SnWyC1BGIyC1YpHy3\"";
            System.out.println(str);
            String str1 = str.replaceAll("\"", "");
            System.out.println("str1:" + str1);

        }
}

