
package com.thoughtworks.homework.strategy.walkingroute;

import java.util.Set;

/**
 * @program: trains_demo
 * @description: 带限制线路数（限制条件为站点数）
 * @author: sunchao
 * @create: 2019-12-07 22:50
 **/
public class MaxTownsRoutesStrategyI implements IWalkingRouteStrategy {
    private final int townLimit;

    public MaxTownsRoutesStrategyI(int townLimit) {
        this.townLimit = townLimit;
    }

    @Override
    public void endPointProcessing(String route, int distance, Set<String> routes) {
        routes.add(route);
    }

    @Override
    public boolean continueTo(String route, int distance) {
        return route.length() <= townLimit;
    }
}
