
package com.thoughtworks.homework.exception;

/**
 * @program: trains_demo
 * @description: 异常信息枚举
 * @author: sunchao
 * @create: 2019-12-07 14:30
 **/
public enum TrainsDemoExceptionMessages {

    // 给定的两个节点距离必须大于0
    STARTING_AND_ENDING_TOWN_DISTANCE_EXCEPTION("TRAINS_VALID_01_01", "the starting and ending town must greater than 0 "),
    // 给定的路线超过了一次
    ROUTE_MORE_THAN_ONCE("TRAINS_VALID_01_02", "the starting and ending town will not be the same town"),
    //给定的路线,开始节点不能和结束节点相同
    STARTING_AND_ENDING_TOWN_SAME("TRAINS_VALID_01_03", "the starting and ending town will not be the same town"),
    // 参数不能为空
    PARAM_VALID_IS_NULL("TRAINS_VALID_02_01", "parameter cannot be null "),
    //输入的Graph不规范
    INPUT_GRAPH_NOT_STANDARDIZED("TRAINS_VALID_02_02", "input graph are not standardized");

    //状态码
    private String code;
    //异常信息
    private String massage;

    TrainsDemoExceptionMessages(String code, String massage) {
        this.code = code;
        this.massage = massage;
    }

    public String getCode() {
        return code;
    }

    public String getMassage() {
        return massage;
    }

    /**
     * 根据错误码获取异常枚举
     * @param code 错误码
     * @return 异常的枚举
     */
    public static TrainsDemoExceptionMessages getEnumByCode(String code) {
        for (TrainsDemoExceptionMessages state : values())
            if (state.getCode().equals(code))
                return state;
        return null;
    }
}
