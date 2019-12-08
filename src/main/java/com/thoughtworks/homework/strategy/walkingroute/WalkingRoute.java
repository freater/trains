
package com.thoughtworks.homework.strategy.walkingroute;

import com.thoughtworks.homework.IRailroad;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: trains_demo
 * @description: 出行
 * @author: sunchao
 * @create: 2019-12-07 23:02
 **/
public class WalkingRoute {
    private final IRailroad railroad;

    public WalkingRoute(IRailroad railroad) {
        this.railroad = railroad;
    }

    /**
     *获取找到的线路集合
     * @param startTown 起点
     * @param destTown 终点
     * @param strategy 策略
     * @return
     */
    public Set<String> walk(char startTown, char destTown, IWalkingRouteStrategy strategy) {
        //找到的路线集合
        Set<String> routesFound = new HashSet<String>(0);
        walk(String.valueOf(startTown), 0, destTown, strategy, routesFound);
        return routesFound;
    }

    /**
     * 递归找出符合条件的路线集合
     * @param currRoute 当前站点，即已经找到的一条线路，如AB
     * @param currDistance 当前获得距离
     * @param destTown 目的站点
     * @param strategy 算法策略
     * @param routesFound 找到的路线集合
     */
    private void walk(String currRoute, int currDistance, char destTown,
                      IWalkingRouteStrategy strategy, Set<String> routesFound) {
        //当前站点，即找到的当前路径上的最后一个点
        char currTown = currRoute.charAt(currRoute.length() - 1);

        //找到路径的最后一个站点等于要求的终点则按照不同策略执行不同算法
        if (currRoute.length() > 1 && currTown == destTown) {
            strategy.endPointProcessing(currRoute, currDistance, routesFound);
        }

        //遍历出所有当前站点的可达站点，即下一站
        for (char nextTown : railroad.getTracksChildKeys(currTown)) {
            //当前路线+下一站点可构成路径
            String nextRoute = currRoute + nextTown;
            //计算路径长度
            int nextDistance = currDistance + railroad.distance(currTown, nextTown);

            //根据不同算法判断是否继续执行
            if (strategy.continueTo(nextRoute, nextDistance)) {
                walk(nextRoute, nextDistance, destTown, strategy, routesFound);
            }
        }
    }
}
