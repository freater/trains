

package com.thoughtworks.homework;


import com.thoughtworks.homework.exception.TrainsDemoException;
import com.thoughtworks.homework.exception.TrainsDemoExceptionMessages;
import com.thoughtworks.homework.exception.common.Verify;
import com.thoughtworks.homework.utils.MapUtil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @program: trains_demo
 * @description: 路段
 * @author: sunchao
 * @create: 2019-12-07 14:30
 **/
public class Railroad implements IRailroad {

    //铁路包含的所有路径，如AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
    private Map<Character, Map<Character, Integer>> tracks =
            new HashMap<Character, Map<Character, Integer>>();

    /**
     * 添加路径
     *
     * @param fromTown 起始站
     * @param toTown   下一个站
     * @param distance  距离
     * @return 添加完成路径集合
     */
    @Override
    public Railroad addTrack(char fromTown, char toTown, int distance) {

        /**
         *  校验是否满足限定的要求
         *   A given route will never appear more than once
         *   for a given route, the starting and ending town will not be the same town
         */

        Verify.verifyTracks(tracks, fromTown, toTown, distance);

        //判断路径是否已经添加
        if (!tracks.containsKey(fromTown)) {
            tracks.put(fromTown, new HashMap<Character, Integer>());
        }
        //给定的线路不能超过一次
        if (tracks.get(fromTown).containsKey(toTown)) {
            throw new TrainsDemoException(TrainsDemoExceptionMessages.ROUTE_MORE_THAN_ONCE);
        }
        //添加下一个站点
        tracks.get(fromTown).put(toTown, distance);
        return this;
    }

    /**
     * 根据传入的站点查找可以到达的所有站点
     * @param fromTown
     * @return
     */
    @Override
    public Set<Character> getTracksChildKeys(char fromTown) {
        return MapUtil.getChildKeySet(tracks, fromTown);
    }

    /**
     * 获取两站的距离
     * @param fromTown 起点
     * @param toTown 下一站点
     * @return 两站之间的距离
     */
    @Override
    public Integer distance(char fromTown, char toTown) {
        if (!tracks.containsKey(fromTown) || !tracks.get(fromTown).containsKey(toTown)) {
            return null;
        }
        return tracks.get(fromTown).get(toTown);
    }

    /**
     * 根据传入的路线获取路线总长度
     * @param route 总路线，如ABC,AD
     * @return
     */
    @Override
    public Integer distance(String route) {
        //总长度
        int totalDistance = 0;
        for (int i = 0; i < route.length() - 1; i++) {
            char fromTown = route.charAt(i);
            char toTown = route.charAt(i + 1);
            Integer distance = distance(fromTown, toTown);
            if (distance == null) {
                return null;
            }
            totalDistance += distance;
        }
        return totalDistance;
    }
}
