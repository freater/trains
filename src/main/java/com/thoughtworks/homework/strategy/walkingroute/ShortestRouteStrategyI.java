
package com.thoughtworks.homework.strategy.walkingroute;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: trains_demo
 * @description: 最短路线
 * @author: sunchao
 * @create: 2019-12-07 22:43
 **/
public class ShortestRouteStrategyI implements IWalkingRouteStrategy {
    //距离出发地的最短距离
    private final Map<Character, Integer> distances = new HashMap<Character, Integer>();
    @Override
    public void endPointProcessing(String route, int distance, Set<String> routes) {
        routes.clear();
        routes.add(route);
    }

    @Override
    public boolean continueTo(String route, int distance) {
        char newTown = route.charAt(route.length() - 1);
        if (!distances.containsKey(newTown) || distance < distances.get(newTown)) {
            distances.put(newTown, distance);
            return true;
        } else {
            return false;
        }
    }
}
