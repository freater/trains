
package com.thoughtworks.homework.factory;

import com.thoughtworks.homework.IRailroad;
import com.thoughtworks.homework.Railroad;
import com.thoughtworks.homework.exception.TrainsDemoException;
import com.thoughtworks.homework.exception.TrainsDemoExceptionMessages;
import com.thoughtworks.homework.strategy.parsegraph.ParseRailroadContext;
import com.thoughtworks.homework.strategy.parsegraph.ParseRailroadStrategy;
import com.thoughtworks.homework.strategy.parsegraph.ParseRailroadStrategyA;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: trains_demo
 * @description: 铁路工厂类
 * @author: sunchao
 * @create: 2019-12-07 16:53
 **/
public class RailroadFactory {

    private static final Map<String,ParseRailroadStrategy> parseStrategyMap=new HashMap<>();
    public  static  final String PARSE_GRAPH_STRATEGY_NAME="A";
    static {
        parseStrategyMap.put(PARSE_GRAPH_STRATEGY_NAME,new ParseRailroadStrategyA());
    }

    public static IRailroad railroadDirectedGraph(String graph,String parseStrategyName) {
        if (graph == null) {
            throw new TrainsDemoException(TrainsDemoExceptionMessages.PARAM_VALID_IS_NULL);
        }
        IRailroad railroad=   new ParseRailroadContext(parseStrategyMap.get(parseStrategyName)).parse(graph);
         return railroad;
    }
}
