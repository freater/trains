package com.thoughtworks.homework.strategy.parsegraph;

import com.thoughtworks.homework.IRailroad;

/**
 * @program: trains_demo
 * @description: A策略，即题目给定的AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
 * @author: sunchao
 * @create: 2019-12-07 20:57
 **/
public class ParseRailroadStrategyA extends ParseRailroadStrategy {
    @Override
    public IRailroad parseAlgorithm(String inputGraph) {
        return super.parse(inputGraph,",","^[A-Z]{2}[0-9]{1,9}$");
    }
}
