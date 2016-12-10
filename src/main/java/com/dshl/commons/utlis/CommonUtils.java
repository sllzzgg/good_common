package com.dshl.commons.utlis;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public final class CommonUtils {

	/**
	 * 验证是不是数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isPatterNum(final String str) {

		if (!isNullObject(str)) {
			Pattern pattern = Pattern.compile("[0-9]*");
			Matcher isNum = pattern.matcher(str);
			return (isNum.matches()) ? true : false;
		} else {
			return false;
		}

	}

	/**
	 * 字符转化为数字int型
	 *
	 * @param str
	 * @return
	 */
	public static Integer StrToNumInt(final String str) {
		try {
			if (isPatterNum(str)) {
				return Integer.parseInt(str);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 字符转化为数字为Long型
	 *
	 * @param str
	 * @return
	 */
	public static Long StrToNumLong(final String str) {
		try {
			if (isPatterNum(str)) {
				return Long.parseLong(str);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 字符转化为List<Long>型
	 *
	 * @param str
	 * @return
	 */
	public static List<Long> StrToLongList(final String str) {
		List<Long> result = new ArrayList<>();
		if (StringUtils.isNotBlank(str)) {
			String[] ids = str.split(",");
			for (String id : ids) {
				if (isPatterNum(id))
					result.add(Long.parseLong(id));
			}
		}
		return result;
	}

	/**
	 * 字符转化为Set<Long>型
	 *
	 * @param str
	 * @return
	 */
	public static Set<Long> StrToLongSet(final String str) {
		Set<Long> result = new HashSet<>();
		try {
			if (str != null) {
				String[] ids = str.split(",");
				for (String id : ids) {
					if (isPatterNum(id)) {
						result.add(Long.parseLong(id));
					}
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 判断是不是为空或为null;
	 *
	 * @param obj
	 * @return
	 */
	public static boolean isNullObject(final Object obj) {
		return (obj == null || "".equals(getNoBlankObject(obj))) ? true : false;
	}

	public static boolean isNotNullObject(final Object obj) {
		return !isNullObject(obj);
	}

	/**
	 * 得到去掉两边空格的字符串
	 *
	 * @param obj
	 * @return
	 */
	public static String getNoBlankObject(final Object obj) {
		return (obj != null) ? obj.toString().trim() : "";
	}

	/**
	 * 生成1-9位随机数
	 *
	 * @param count
	 *            位数
	 * @return 返回count位随机数
	 */
	public static String getRandomNum(int count) {
		int[] array = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		Random rand = new Random();
		for (int i = 10; i > 1; i--) {
			int index = rand.nextInt(i);
			int tmp = array[index];
			array[index] = array[i - 1];
			array[i - 1] = tmp;
		}
		String result = "";
		for (int i = 0; i < count && i < 10; i++) {
			result = result + array[i];
		}
		return result;
	}

	/**
	 * 主键生成器，基于时间戳+机器地址的
	 * 
	 * @return 主键
	 */
	public static String getPrimaryKey() {
		return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
	}

	/**
	 * @param date
	 * @return
	 */
	public static java.sql.Date StringToSqlDate(String date) {
		return java.sql.Date.valueOf(date);
	}

	/**
	 * @param n
	 *            随即生成N个大写字母组成的字符串
	 * @return
	 */
	public static String randomStr(int n) {
		String str = "";
		Random r = new Random();
		for (int i = 0; i < n; i++) {
			char m = (char) (r.nextInt(26) + 65);
			str += m;
		}
		return str;
	}

	/**
	 * 转化MAP
	 *
	 * @param mapValue
	 *            页面按struts2的格式传map进来 进行转换
	 * @return
	 */
	public static Map<String, Object> convertMap(Map<String, Object> mapValue) {
		Map<String, Object> map = new HashMap<String, Object>();
		Iterator<String> iterator = mapValue.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			Object o = mapValue.get(key);
			if (o instanceof String[]) {
				String[] values = (String[]) o;
				if (values.length == 1) {
					map.put(key, values[0].toString());
				} else {
					map.put(key, values);
				}

			} else {
				map.put(key, o);
			}
		}
		return map;
	}

	public static String mysqlDateToCurrentTime(String strDate) {
		if (CommonUtils.isNullObject(strDate)) {
			return String.valueOf(System.currentTimeMillis());
		}
		Integer length = strDate.length();

		if (length > 14) {
			return String.valueOf(System.currentTimeMillis());
		}
		for (int i = 1; i < 14 - length; i++) {
			strDate += 0;
		}
		return strDate;
	}

	// 电信
	//
	// 中国电信手机号码开头数字
	// 2G/3G号段（CDMA2000网络）133、153、180、181、189
	// 4G号段 177
	// 联通
	//
	// 中国联通手机号码开头数字
	// 2G号段（GSM网络）130、131、132、155、156
	// 3G上网卡145
	// 3G号段（WCDMA网络）185、186
	// 4G号段 176、185[1]
	// 移动
	//
	// 中国移动手机号码开头数字
	// 2G号段（GSM网络）有134x（0-8）、135、136、137、138、139、150、151、152、158、159、182、183、184。
	// 3G号段（TD-SCDMA网络）有157、187、188
	// 3G上网卡 147
	// 4G号段 178

	public static boolean isMobile(String mobile) {
		Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(17[0,6-8])|(18[0-9]))\\d{8}$");
		Matcher m = p.matcher(mobile);
		return m.matches();
	}

}
