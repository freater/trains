
package com.thoughtworks.homework.strategy.walkingroute;

import java.util.Set;

/**
 * @program: trains_demo
 * @description: 精确路径长度
 * @author: sunchao
 * @create: 2019-12-07 22:30
 **/
public class ExactRouteDistanceStrategyI implements IWalkingRouteStrategy {
    private final int townCount;

    public ExactRouteDistanceStrategyI(int townCount) {
        this.townCount = townCount;
    }

    @Override
    public void endPointProcessing(String route, int distance, Set<String> routes) {
        if (route.length() == townCount) {
            routes.add(route);
        }
    }

    @Override
    public boolean continueTo(String route, int distance) {
        return route.length() <= townCount;
    }
}
