package com.thoughtworks.homework.factory;

import com.thoughtworks.homework.strategy.parseroute.IParseRoutesStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: trains_demo
 * @description: 解析路径的简单工厂
 * @author: sunchao
 * @create: 2019-12-08 09:52
 **/
public class ParseRoutesFactory {
   private  Map<String,IParseRoutesStrategy> parseRoutesStrategyName=new HashMap<>();

   public ParseRoutesFactory(Map<String,IParseRoutesStrategy> parseRoutesStrategyName){
       this.parseRoutesStrategyName=parseRoutesStrategyName;
   }

   public IParseRoutesStrategy getParseRoutesStrategy(String name){
       return parseRoutesStrategyName.get(name);
   }

}
