
package com.thoughtworks.homework.strategy.walkingroute;

import java.util.Set;

/**
 * @program: trains_demo
 * @description: 最大路线数
 * @author: sunchao
 * @create: 2019-12-07 22:36
 **/
public class MaximumRoutesNumberStrategyI implements IWalkingRouteStrategy {
    private final int maxLength;

    public MaximumRoutesNumberStrategyI(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void endPointProcessing(String route, int distance, Set<String> routes) {
        routes.add(route);
    }

    @Override
    public boolean continueTo(String route, int distance) {
        return distance < maxLength;
    }


}
