package com.curtain.aoplog;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * @Author Curtain
 * @Date 2023/2/24 14:20
 * @Description
 */
@Component
@EnableAsync(proxyTargetClass = true)
public class CollectorExecutor {

    /**
     * 异步 执行收集器
     *
     * @param collector 收集器
     * @param data      数据对象
     */
    @Async("collectorAsyncExecutor")
    public <D> void asyncExecute(Collector<D> collector, D data) {
        execute(collector, data);
    }

    /**
     * 同步 执行收集器
     *
     * @param collector 收集器
     * @param data      数据对象
     */
    public <D> void execute(Collector<D> collector, D data) {
        collector.collect(data);
    }
}
