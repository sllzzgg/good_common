package com.dshl.commons.utlis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

/**
 * Map操作公用类
 * 
 * @author zhouguojun
 *
 */
public final class MapUtils {

	/**
	 * 处理普通召回字段
	 * 
	 * @param source
	 *            源
	 * @param target
	 *            Filed
	 * @param returnAll
	 *            是否返回全部
	 * @return
	 */
	public static Map<String, Object> changeFiled(final Map<String, Object> source, final Map<String, String> target,
			final boolean returnAll) {
		Map<String, Object> document = new HashMap<>();
		if (source != null && null != target) {
			for (Map.Entry<String, Object> entry : source.entrySet()) {
				String responseStr = target.get(entry.getKey());
				if (StringUtils.isNotBlank(responseStr)) {
					document.put(responseStr, entry.getValue());
				} else if (returnAll) {
					document = source;
				}
			}
		} else if (returnAll) {
			document = source;
		}
		return document;
	}

	/**
	 * 处理普通召回字段
	 * 
	 * @param source
	 *            源
	 * @param target
	 *            Filed
	 * @return
	 */
	public static Map<String, Object> changeFiled(final Map<String, Object> source, final List<String> target) {
		Map<String, Object> document = new HashMap<>();
		if (source != null && null != target && target.size() > 0) {
			for (String key : target) {
				Object value = source.get(key);
				if (value != null)
					document.put(key, value);
			}
		} else
			document = source;

		return document;
	}

}
