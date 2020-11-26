package com.yanghui.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


/**
 * JACKSON工具类
 */
public class SerializeUtil {

    private static ObjectMapper om;

    private static Logger logger = LoggerFactory.getLogger(SerializeUtil.class);

    public static ObjectMapper getObjectMapper() {
        if (om == null) {
            synchronized (SerializeUtil.class) {
                if (om == null) {
                    om = new CustomObjectMapper();
                }
            }
        }
        return om;
    }

    /**
     * json转对象
     */
    public static <T> T decodeJson(String json, Class<T> cls) {
        if (StringUtil.isEmpty(json)) {
            return (T) new Object();
        }
        Object result = transStringToJson(json, cls, "one");
        if (result == null) {
            //转换失败原因可能是字符本身原因，做一下过滤
            result = transStringToJson(tranJsonStr(json), cls, "two");
        }
        return (T) result;
    }

    public static <T> T transStringToJson(String json, Class<T> cls, String type) {
        Object result = null;
        try {
            result = getObjectMapper().readValue(json, cls);
        } catch (IOException e) {
            if (type.equals("two")) {
                logger.error(String.format("反序列化失败,序列信息 %s,失败原因 %s", json, e.getMessage()));
            }
        }
        return (T) result;
    }

    /**
     * 对象转json
     */
    public static String encodeJson(Object obj) {
        if (obj == null || StringUtil.isEmpty(obj.toString())) {
            return "";
        }
        String result = null;
        try {
            result = getObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            logger.error(String.format("对象序列化失败,对象%s,失败原因 %s", obj, e.getMessage()));
        }
        return result;
    }

    /**
     * 暂不支持复杂嵌套  JSON转list
     */
    public static <T> List<T> decodeJsonList(String json, Class<T> cls) {
        if (StringUtil.isEmpty(json)) {
            return new ArrayList<>();
        }
        List<T> result = transJsonToList(json, cls, "one");
        if (result == null || result.size() == 0) {
            //转换失败原因可能是字符本身原因，做一下过滤
            result = transJsonToList(tranJsonStr(json), cls, "two");
        }
        return result;
    }

    public static <T> List<T> transJsonToList(String json, Class<T> cls, String type) {
        List<Object> result = new ArrayList<>();
        try {
            result = getObjectMapper().readValue(json, new TypeReference<List<T>>() {
                public Type getType() {
                    ParameterizedType type = new ParameterizedType() {
                        @Override
                        public Type getRawType() {
                            return List.class;
                        }

                        @Override
                        public Type getOwnerType() {
                            return null;
                        }

                        @Override
                        public Type[] getActualTypeArguments() {
                            return new Type[]{cls};
                        }
                    };
                    return type;
                }
            });
        } catch (Throwable e) {
            //第二次转换失败再打印日志
            if (type.equals("two")) {
                logger.error(String.format("反序列化LIST失败，数据 %s，目标对象 %s,失败原因 %s", json, cls, e.getMessage()));
            }
        }
        return (List<T>) result;
    }

    /**
     * 字符串过滤处理 否则json 转换各种毛病
     */
    public static String tranJsonStr(String json) {
        if (json.startsWith("\"") && json.endsWith("\"")) {
            json = json.substring(1, json.length() - 1);
        }
        if (json.contains("\\\"")) {
            json = json.replaceAll("\\\\\\\"", "\\\"");
        }
        if (json.contains("\\n")) {
            json = json.replaceAll("\\\\n", "");
        }
        return json;
    }

}