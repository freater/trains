package com.thoughtworks.homework.strategy.parseroute;

/**
 * @program: trains_demo
 * @description: 解析路径中带横线路径
 * @author: sunchao
 * @create: 2019-12-08 09:37
 **/
public class IParseRouteWithHorizLineStrategy implements IParseRoutesStrategy {
    @Override
    public String formatRoute(String route) {
        return route.replaceAll("-","");
    }
}
