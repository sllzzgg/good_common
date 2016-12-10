package com.dshl.commons.utlis;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * POST 验证规约
 * @author NOAH
 *
 */
public class PostAppsecret {

	public String Post(String body){

		String appkey = "AYUEJ1AWWHKTYENYUG1RP1B52SY5R1OJ";
		
		int len = body.length();
		
		if(len > 50) {
			body = body.substring(0, 50);
		}
		
		String str = body + appkey;
	
		String md5Str = String.valueOf(DigestUtils.md5Hex(str.toString()));
		
		return md5Str;
	}
	
}
