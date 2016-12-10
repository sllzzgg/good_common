package com.dshl.commons.utlis;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.MissingNode;

/**
 * JSON操作公用类
 * 
 * @author Tony
 */
@SuppressWarnings("unchecked")
public final class JSONUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(JSONUtils.class);
	public static final ObjectMapper OBJECT_MAPPER;

	public static final TypeReference<Map<String, Object>> MAP_TYPE_REF = new TypeReference<Map<String, Object>>() {
	};
	public static final TypeReference<List<Map<String, Object>>> LIST_MAP_TYPE_REF = new TypeReference<List<Map<String, Object>>>() {
	};

	static {
		OBJECT_MAPPER = new ObjectMapper();
		OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

	}

	public static JsonNode toJsonNode(String json) {
		JsonNode jsonNode = MissingNode.getInstance();
		try {
			jsonNode = OBJECT_MAPPER.readValue(json, JsonNode.class);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return jsonNode;
	}

	public static JsonNode toJsonNode(Object obj) {
		String json = toJson(obj);
		return toJsonNode(json);
	}

	public static <T> T toClzInstance(String json, Class<T> clz) {
		T obj = null;
		try {
			obj = OBJECT_MAPPER.readValue(json, clz);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return obj;
	}

	public static <T> T toClzInstance(Object object, Class<T> clz) {
		return toClzInstance(toString(object), clz);
	}

	public static String toString(Object obj) {
		try {
			return OBJECT_MAPPER.writeValueAsString(obj);
		} catch (IOException e) {
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public static String toJson(Object obj) {
		return toJson(obj, false);
	}

	public static String toJson(Object obj, boolean pretty) {
		String json = null;
		try {
			if (pretty) {
				json = OBJECT_MAPPER.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			} else {
				json = OBJECT_MAPPER.writeValueAsString(obj);
			}
		} catch (IOException e) {
		}

		return json;
	}

	public static <T> T toObject(String json, TypeReference<T> valueTypeRef) {
		if (null != json) {
			try {
				return (T) OBJECT_MAPPER.readValue(json, valueTypeRef);
			} catch (IOException e) {
				LOGGER.error(e.getMessage());
			}
		}
		return null;
	}

	public static Map<String, Object> toMap(String json) {
		if (!StringUtils.isBlank(json)) {
			try {
				return OBJECT_MAPPER.convertValue(json, MAP_TYPE_REF);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		}
		return null;
	}

	public static Map<String, Object> toMap(Object obj) {
		if (null != obj) {
			try {
				return OBJECT_MAPPER.convertValue(obj, MAP_TYPE_REF);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
		}
		return null;
	}

}
