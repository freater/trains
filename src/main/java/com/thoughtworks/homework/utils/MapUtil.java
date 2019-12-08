
package com.thoughtworks.homework.utils;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * @program: trains_demo
 * @description: Set集合工具类
 * @author: sunchao
 * @create: 2019-12-07 16:17
 **/
public class MapUtil {

    /**
     *根据key获取存储的子Map的所有key集合
     * @param key
     * @return
     */
    public  static  Set<Character> getChildKeySet(Map<Character, Map<Character, Integer>> map,char key) {
        if (!map.containsKey(key)) {
            return Collections.emptySet();
        }
        return map.get(key).keySet();
    }

}
