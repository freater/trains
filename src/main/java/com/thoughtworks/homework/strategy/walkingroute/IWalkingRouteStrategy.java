
package com.thoughtworks.homework.strategy.walkingroute;

import java.util.Set;

/**
 * 行走路线
 */
public interface IWalkingRouteStrategy {

    /**
     *终点处理，找到终点节点的处理方式
     * @param route
     * @param distance
     * @return
     */
   public abstract void endPointProcessing(String route, int distance, Set<String> routes);

    /**
     *继续执行的条件
     * @param route
     * @param distance
     * @return
     */
    public abstract boolean continueTo(String route, int distance);
}
