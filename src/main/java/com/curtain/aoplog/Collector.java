package com.curtain.aoplog;


/**
 * @Author Curtain
 * @Date 2023/2/24 14:20
 * @Description
 */
@FunctionalInterface
public interface Collector<T> {

    /**
     * 收集数据对象
     *
     * @param data 数据对象
     */
    void collect(T data);
}
