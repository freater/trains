
package com.thoughtworks.homework;

import com.thoughtworks.homework.factory.ParseRoutesFactory;
import com.thoughtworks.homework.strategy.parseroute.IParseRouteWithHorizLineStrategy;
import com.thoughtworks.homework.strategy.parseroute.IParseRoutesStrategy;
import com.thoughtworks.homework.strategy.parseroute.ParseRoute;
import com.thoughtworks.homework.strategy.walkingroute.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: trains_demo
 * @description: 路线计算
 * @author: sunchao
 * @create: 2019-12-07 23:13
 **/
public class RailroadCalc {
    private final IRailroad railway;
    private final WalkingRoute walker;
    private static ParseRoutesFactory parseRoutesFactory;
    public static final String PARSE_ROUTES_STRATEGY_NAME="parse_strategy_a";
    static{
        Map<String, IParseRoutesStrategy> parseRoutesStrategy =new HashMap<>();
        parseRoutesStrategy.put(PARSE_ROUTES_STRATEGY_NAME,new IParseRouteWithHorizLineStrategy());
        parseRoutesFactory=new ParseRoutesFactory(parseRoutesStrategy);
    }

    public RailroadCalc(IRailroad railway) {
        this.railway = railway;
        this.walker = new WalkingRoute(railway);
    }

    /**
     * 计算路线距离
     * @param route 路线 解决问题 1-5（A-B-C.A-D.A-D-C.A-E-B-C-D.A-E-D）
     * @parseRoutesStrategyName 解析策略的名称
     * @return
     */
    public Integer distance(String route,String parseRoutesStrategyName) {
        return railway.distance(new ParseRoute(parseRoutesFactory.getParseRoutesStrategy(parseRoutesStrategyName)).formatRoute(route));
    }


    /**
     * 最大经过站点的线路数，解决问题6  C-C (限制最多3站)
     * @param townLimit 最大站点数
     * @param startTown 起点
     * @param destTown 终点
     * @return 路线数
     */
    public Integer tripsNumWithMaxStops(int townLimit,char startTown,char destTown) {
        IWalkingRouteStrategy walkingRouteStrategy = new MaxTownsRoutesStrategyI(townLimit+1);
        Set<String> routes6 = walker.walk(startTown, destTown, walkingRouteStrategy);
        return routes6.size();
    }

    /**
     *精确限制停靠站点的线路数，解决问题7 A-C(限制恰好4站)
     * @param townCount 恰好路过的站点数
     * @param startTown 起点
     * @param destTown 终点
     * @return 路线数
     */
    public Integer tripsNumWithExactStops(int townCount,char startTown,char destTown) {
        IWalkingRouteStrategy walkingRouteStrategy = new ExactRouteDistanceStrategyI(townCount+1);
        Set<String> routes = walker.walk(startTown, destTown, walkingRouteStrategy);
        return routes.size();
    }

    /**
     * 两站之间的最短距离，解决问题8.9 A-C .B-B
     * @param startTown 起点
     * @param destTown 终点
     * @return 距离
     */
    public Integer shortestDistance(char startTown,char destTown) {
        IWalkingRouteStrategy walkingRouteStrategy = new ShortestRouteStrategyI();
        Set<String> routes = walker.walk(startTown, destTown, walkingRouteStrategy);
        if (!routes.isEmpty()) {
            String route = routes.iterator().next();
            return railway.distance(route);
        } else {
            return null;
        }
    }


    /**
     * 限制最大距离不超范围的路线数，解决问题10 C-C(最大长度不超30)
     * @param maxLength 最大距离
     * @param startTown 起点
     * @param descTown 终点
     * @return 路线数
     */
    public Integer routeNumWithDistanceLimit(int maxLength,char startTown,char descTown) {
        IWalkingRouteStrategy walkingRouteStrategy = new MaximumRoutesNumberStrategyI(maxLength);
        Set<String> routes = walker.walk(startTown, descTown, walkingRouteStrategy);
        return routes.size();
    }

}
