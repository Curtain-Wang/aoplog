package com.curtain.aoplog.collector;

import com.curtain.aoplog.LogData;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author Curtain
 * @Date 2021/12/10 10:33
 * @Description collect app log 
 */
@Slf4j
public class DefaultLogCollector implements LogCollector {
    String logStr = "\n" +
            "{\n" +
            "    \"method\": \"%s\",\n" +
            "    \"args\": \"%s\",\n" +
            "    \"response\": \"%s\",\n" +
            "    \"isSuccess\": \"%b\"\n" +
            "}";
    @Override
    public void collect(LogData logData) {
        try {
            if (!logData.isSuccess()){
                log.info(String.format(logStr, logData.getMethod(), new ObjectMapper().writeValueAsString(logData.getArgs()), new ObjectMapper().writeValueAsString(logData.getRespBody()), logData.isSuccess()));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
