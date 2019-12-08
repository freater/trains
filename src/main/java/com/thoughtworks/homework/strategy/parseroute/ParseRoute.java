package com.thoughtworks.homework.strategy.parseroute;

/**
 * @program: trains_demo
 * @description: 解析路径上下文
 * @author: sunchao
 * @create: 2019-12-08 09:39
 **/
public class ParseRoute {
    private IParseRoutesStrategy parseRoutesStrategy;

    public ParseRoute(IParseRoutesStrategy parseRoutesStrategy){
        this.parseRoutesStrategy=parseRoutesStrategy;
    }

    public  String formatRoute(String route){
       return parseRoutesStrategy.formatRoute(route);
    }
}
