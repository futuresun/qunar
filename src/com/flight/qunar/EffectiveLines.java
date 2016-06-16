package com.flight.qunar;

import java.io.*;
import java.util.Scanner;

/**
 *
 * 问题：统计一个Java文件的有效行数
 *      1. 有效不包括空行
 *      2. 不考虑代码间有多行注释的情况
 *
 * Created by 冯麒 on 2016/6/14.
 */

public class EffectiveLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入需要统计的java文件的绝对路径:");
        while (scanner.hasNext()) {
            int lines = countLines(scanner.nextLine());
            System.out.println("该java文件的有效行数为: " + lines + " 行");
            System.out.println("输入需要统计的java文件的绝对路径:");
        }
    }
    public static int countLines(String filePath) {
        int count = 0;//统计结果
        boolean startFlag = false;
        File file = new File(filePath);
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            //不统计package，import；从public class或class声明行开始统计
            String temp;
            while ((temp=bufferedReader.readLine()) != null) {
                if(temp.trim().startsWith("//") || temp.trim().equals("")) continue;
                if(startFlag) {
                    count++;
                } else if(temp.trim().startsWith("public class") || temp.trim().startsWith("class")) {
                    startFlag = true;
                    count++;
                }
            }
        } catch (IOException e) {
            System.out.println("路径有误!");
        } finally {
            try {
                if(bufferedReader != null) {
                    bufferedReader.close();
                }
            } catch (Exception e) {

            }
        }
        return count;
    }
}