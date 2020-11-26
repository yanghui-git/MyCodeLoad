package com.yanghui.jackson;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 自定义对象与JSON解析配置
 */
public class CustomObjectMapper extends ObjectMapper {
	private static final Logger logger = LoggerFactory.getLogger(CustomObjectMapper.class);
	private static final long serialVersionUID = 1L;
	
	public static CustomObjectMapper instance;
	
	public CustomObjectMapper() {
		instance = this;
		SimpleModule module = new SimpleModule("RestModule");
		this.registerModule(module);	
	//	this.configure(SerializationFeature.INDENT_OUTPUT, true);
		//是否美化输出 即有无换行等
		this.configure(SerializationFeature.INDENT_OUTPUT, false);
		this.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		this.configure(SerializationFeature.WRITE_ENUMS_USING_INDEX, false);
		this.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
		this.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
		this.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		this.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		logger.debug("CustomObjectMapper created");		
	}
}