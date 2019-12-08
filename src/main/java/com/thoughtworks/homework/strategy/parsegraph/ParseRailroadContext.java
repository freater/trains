
package com.thoughtworks.homework.strategy.parsegraph;

import com.thoughtworks.homework.IRailroad;

/**
 * @program: trains_demo
 * @description: 解析Graph 获取Railroad
 * @author: sunchao
 * @create: 2019-12-07 21:15
 **/
public class ParseRailroadContext
{
    private ParseRailroadStrategy parseRailroadStrategy;

    public ParseRailroadContext(ParseRailroadStrategy parseRailroadStrategy){
        this.parseRailroadStrategy = parseRailroadStrategy;
    }

    public IRailroad parse(String graph){
       return parseRailroadStrategy.parseAlgorithm(graph);
    }
}
