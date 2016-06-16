package com.flight.qunar;

import java.io.File;
import java.util.Scanner;

/**
 * 问题：根据指定项目目录下（可以认为是java源文件目录中），统计被import最多的类，前十个是什么。
 *
 * 1. 暂时不考虑“.*”的情况
 * 2. 暂时不考虑静态导入的情况
 * 3. 相同统计次数按照字典序列进行排序
 *
 * Created by 冯麒 on 2016/6/16.
 */
public class CountMostImport {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入项目目录的绝对路径:");
        while (scanner.hasNext()) {
            countMostImport(scanner.nextLine());
            System.out.println("输入项目目录的绝对路径:");
        }
    }

    public static void countMostImport(String path) {
        File file = new File(path);

    }

}
