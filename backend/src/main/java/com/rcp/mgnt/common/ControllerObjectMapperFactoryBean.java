/**
 * 
 */
package com.rcp.mgnt.common;

import org.springframework.beans.factory.config.AbstractFactoryBean;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ControllerObjectMapperFactoryBean extends
		AbstractFactoryBean<ObjectMapper> {

	public Class<ObjectMapper> getObjectType() {
		return ObjectMapper.class;
	}

	public ObjectMapper createInstance() {
		// create and return ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		return mapper;
	}

}
