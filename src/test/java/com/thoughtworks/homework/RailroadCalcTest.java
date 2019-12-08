package com.thoughtworks.homework;

import com.thoughtworks.homework.exception.TrainsDemoException;
import com.thoughtworks.homework.exception.TrainsDemoExceptionMessages;
import com.thoughtworks.homework.factory.RailroadFactory;
import com.thoughtworks.homework.utils.PrintUtils;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * @program: trains_demo
 * @description: 测试
 * @author: sunchao
 * @create: 2019-12-08 10:19
 **/
public class RailroadCalcTest {

    private static final String GRAPH = "AB5,BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7";
    public static IRailroad railroad = RailroadFactory.railroadDirectedGraph(GRAPH, RailroadFactory.PARSE_GRAPH_STRATEGY_NAME);
    public static RailroadCalc railroadCalc = new RailroadCalc(railroad);

    /**
     * 运行此方法测试 所有用例
     */
    @Test
    public void testAllScenarios() {
        try{
            distanceTest();
            tripsNumWithMaxStopsTest();
            tripsNumWithExactStopsTest();
            shortestDistanceTest();
            routeNumWithDistanceLimitTest();
        }catch (TrainsDemoException trainsDemoException){
            System.out.println(trainsDemoException.getTrainsDemoExceptionMessages().getMassage());
        }catch (Exception e){
            System.out.println("unknown  exception");
        }

    }

    @Test
    public void testException(){
        try{
            IRailroad railroad = RailroadFactory.railroadDirectedGraph("AB5|BC4|CD8|DC8|DE6|AD5", RailroadFactory.PARSE_GRAPH_STRATEGY_NAME);
            RailroadCalc railroadCalc = new RailroadCalc(railroad);
        }catch (TrainsDemoException trainsDemoException){
            Assert.assertEquals(trainsDemoException.getTrainsDemoExceptionMessages().getCode(), TrainsDemoExceptionMessages.INPUT_GRAPH_NOT_STANDARDIZED.getCode());
            System.out.println(trainsDemoException.getTrainsDemoExceptionMessages().getMassage());
        }catch (Exception e){
            System.out.println("unknown  exception");
        }

    }


    /**
     * 仅测试经过站点的距离
     */
    @Test
    public void distanceTest() {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("#1", "A-B-C");
        map.put("#2", "A-D");
        map.put("#3", "A-D-C");
        map.put("#4", "A-E-B-C-D");
        map.put("#5", "A-E-D");

        Map<String, String> distanceMap = new HashMap<>();
        distanceMap.put("#1", "9");
        distanceMap.put("#2", "5");
        distanceMap.put("#3", "13");
        distanceMap.put("#4", "22");
        distanceMap.put("#5", "0");


        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            Integer distance = railroadCalc.distance(entry.getValue(), RailroadCalc.PARSE_ROUTES_STRATEGY_NAME);
            //断言通过才打印
            Assert.assertEquals(distanceMap.get(entry.getKey()), String.valueOf(distance != null ? distance : "0"));
            PrintUtils.println(entry.getKey(), distance);
        }
    }

    /**
     * 仅测试带最大限制站点的路线数
     */
    @Test
    public void tripsNumWithMaxStopsTest() {

        int tripsNum = railroadCalc.tripsNumWithMaxStops(3, 'C', 'C');
        Assert.assertEquals(2, tripsNum);
        PrintUtils.println("#6", tripsNum);
    }

    /**
     * 仅测试带精准限制站点的路线数
     */
    @Test
    public void tripsNumWithExactStopsTest() {

        int tripsNum = railroadCalc.tripsNumWithExactStops(4, 'A', 'C');
        Assert.assertEquals(3, tripsNum);
        PrintUtils.println("#7", tripsNum);
    }

    /**
     * 仅测试最短距离
     */
    @Test
    public void shortestDistanceTest() {

        Map<String, String> map = new LinkedHashMap<>();
        map.put("#8", "AC");
        map.put("#9", "BB");

        Map<String, String> distanceMap = new LinkedHashMap<>();
        distanceMap.put("#8", "9");
        distanceMap.put("#9", "9");
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            char[] towns = entry.getValue().toCharArray();
            int shortestDistance = railroadCalc.shortestDistance(towns[0], towns[1]);
            Assert.assertEquals(distanceMap.get(entry.getKey()), String.valueOf(shortestDistance));

            PrintUtils.println(entry.getKey(), shortestDistance);
        }
    }

    /**
     * 仅测试不超过限制长度的路线数
     */
    @Test
    public void routeNumWithDistanceLimitTest() {
        int routeNum = railroadCalc.routeNumWithDistanceLimit(30, 'C', 'C');
        Assert.assertEquals(7, routeNum);
        PrintUtils.println("#10", routeNum);
    }


}
