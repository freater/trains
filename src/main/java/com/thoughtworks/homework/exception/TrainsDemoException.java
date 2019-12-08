
package com.thoughtworks.homework.exception;

/**
 * @program: trains_demo
 * @description: 自定义异常
 * @author: sunchao
 * @create: 2019-12-07 14:30
 **/
public class TrainsDemoException extends RuntimeException {
    private TrainsDemoExceptionMessages trainsDemoExceptionMessages;

    public TrainsDemoException(TrainsDemoExceptionMessages trainsDemoExceptionMessages) {
        this.trainsDemoExceptionMessages = trainsDemoExceptionMessages;
    }

    public TrainsDemoExceptionMessages getTrainsDemoExceptionMessages() {
        return trainsDemoExceptionMessages;
    }

    public void setTrainsDemoExceptionMessages(TrainsDemoExceptionMessages trainsDemoExceptionMessages) {
        this.trainsDemoExceptionMessages = trainsDemoExceptionMessages;
    }
}
