
package com.thoughtworks.homework.exception.common;

import com.thoughtworks.homework.exception.TrainsDemoException;
import com.thoughtworks.homework.exception.TrainsDemoExceptionMessages;

import java.util.Map;

/**
 * @program: trains_demo
 * @description:校验类
 * @author: sunchao
 * @create: 2019-12-07 15:52
 **/
public class Verify {
    //校验路径
    public static void verifyTracks(Map<Character, Map<Character, Integer>> tracks,char startTown, char endTown, int distance){
        //距离必须大于0，小于等于0则报错
        if (distance <= 0) {
            throw new TrainsDemoException(TrainsDemoExceptionMessages.STARTING_AND_ENDING_TOWN_DISTANCE_EXCEPTION);
        }
        //开始节点不能等于结束节点
        if (startTown == endTown) {
            throw new TrainsDemoException(TrainsDemoExceptionMessages.STARTING_AND_ENDING_TOWN_SAME);
        }

    }
}
