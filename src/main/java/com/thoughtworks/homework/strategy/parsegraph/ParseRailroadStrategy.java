
package com.thoughtworks.homework.strategy.parsegraph;

import com.thoughtworks.homework.IRailroad;
import com.thoughtworks.homework.Railroad;
import com.thoughtworks.homework.exception.TrainsDemoException;
import com.thoughtworks.homework.exception.TrainsDemoExceptionMessages;

/**
 * @program: trains_demo
 * @description: 解析输入的图
 * @author: sunchao
 * @create: 2019-12-07 20:51
 **/
public abstract class ParseRailroadStrategy {

    public abstract IRailroad parseAlgorithm(String inputGraph);

    protected IRailroad parse(String input,String  splitRegex,String trackRegex){
        IRailroad railway = new Railroad();
        String[] tracks = input.toUpperCase().split(splitRegex);
        for (String track : tracks) {
            track = track.trim();
            if (track == "") {
                continue;
            }
            if (!track.matches(trackRegex)) {
                throw new TrainsDemoException(TrainsDemoExceptionMessages.INPUT_GRAPH_NOT_STANDARDIZED);
            }
            char fromTown = track.charAt(0);
            char toTown = track.charAt(1);

            int distance = Integer.parseInt(track.substring(2));
            railway.addTrack(fromTown, toTown, distance);
        }
        return railway;
    }
}
