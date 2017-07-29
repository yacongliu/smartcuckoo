package com.yacongliu.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author yacongliu on 2017/7/28.
 * @desc Json 帮助类
 * @since v1.0.0
 */
public final class JsonUtil {
        private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

        private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

        /**
         * @param obj
         * @return
         * @desc 将对象序列化成json字符串
         */
        public static String toJson(Object obj) {
                try {
                        return OBJECT_MAPPER.writeValueAsString(obj);
                } catch (JsonProcessingException e) {
                        LOGGER.error("convert POJO to JSON failure", e);
                        throw new RuntimeException(e);
                }
        }

        /**
         * @param jsonString
         * @param valueType
         * @param <T>
         * @return T
         * @description json反序列成对象
         */
        public static <T> T parse(String jsonString, Class<T> valueType) {
                try {
                        return OBJECT_MAPPER.readValue(jsonString, valueType);
                } catch (IOException e) {
                        LOGGER.error("convert JSON to POJO failure", e);
                        throw new RuntimeException(e);
                }
        }
}
