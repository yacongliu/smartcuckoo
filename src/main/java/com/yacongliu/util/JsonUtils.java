package com.yacongliu.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author yacongliu on 2017/7/28.
 * @desc Json 帮助类
 * @since v1.0.0
 */
public final class JsonUtils {
        public JsonUtils() {
        }

        public static ObjectMapper getDefaultObjectMapper() {
                ObjectMapper mapper = new ObjectMapper();
                //设置将对象转换成JSON字符串时候:包含的属性不能为空或"";
                //Include.Include.ALWAYS 默认
                //Include.NON_DEFAULT 属性为默认值不序列化
                //Include.NON_EMPTY 属性为 空（""）  或者为 NULL 都不序列化
                //Include.NON_NULL 属性为NULL 不序列化
                mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                //设置将MAP转换为JSON时候只转换值不等于NULL的
                mapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
                mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                //设置有属性不能映射成PO时不报错
                return mapper;
        }

        /**
         * @param obj
         * @return
         * @desc 将对象序列化成json字符串
         */
        public static String toJson(Object obj) {
                try {
                        return getDefaultObjectMapper().writeValueAsString(obj);
                } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                }
        }

        /**
         * @param jsonString
         * @param valueType
         * @param <T>
         * @return
         * @desc json反序列成对象
         */
        public static <T> T parse(String jsonString, Class<T> valueType) {
                try {
                        return getDefaultObjectMapper().readValue(jsonString, valueType);
                } catch (IOException e) {
                        throw new RuntimeException(e);
                }
        }
}
