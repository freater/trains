package com.thoughtworks.homework.utils;

/**
 * @program: trains_demo
 * @description: 打印工具类
 * @author: sunchao
 * @create: 2019-12-08 12:50
 **/
public class PrintUtils {

    public static void println(String code,Object result) {
        System.out.println(code+":"+((result != null&&!result.equals("")) ? result.toString() : "NO SUCH ROUTE"));
    }


}
