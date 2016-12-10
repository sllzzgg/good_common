package com.dshl.commons.utlis;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.codec.binary.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
/**
 * API认证规约
 * @author Noah
 *
 */
public class APIApprove {
	
	public String CertificationImpl(Map<String, String> valueMap,String appsecret) {

		Map<String, String> signParams = new TreeMap<String, String>();

		for (Map.Entry<String, String> entry : valueMap.entrySet()) {
			//1.对参数列表按照参数名称进行排序
			signParams.put(entry.getKey(), entry.getValue());

		}

		StringBuilder paramsStr = new StringBuilder();

		Set<Map.Entry<String, String>> paramsEntry = signParams.entrySet();

		for (Map.Entry<String, String> entry : paramsEntry) {
			//2.1对排序后的参数列表按照（key+value）方式进行拼接 , 最后尾追appsecret
			paramsStr.append(entry.getKey())
					.append(org.apache.commons.lang.StringUtils.isEmpty(entry.getValue()) ? "-" : entry.getValue());

		}
		//2.2尾追appsecret
		paramsStr.append(appsecret);
		
		//3.把拼接的字符串计算MD5，并转换成十六进制
		String sign = DigestUtils.md5Hex(StringUtils.getBytesUtf8(paramsStr.toString()));

		return sign;
	}
	
}
