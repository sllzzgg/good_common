package com.dshl.commons.utlis;

import org.apache.commons.lang.StringUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

/**
 * 汉字转换位汉语拼音，英文字符不变
 * 
 * @author zhouguojun
 *
 */
public final class SpellUtils {

	/**
	 * 汉字转换位汉语拼音首字母，英文字符不变
	 * 
	 * @param str
	 * 
	 * @return
	 */
	public static String StringToFirstSpell(final String str) {
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isNotBlank(str)) {
			char[] nameChar = str.toCharArray();
			HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
			defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
			defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
			for (int i = 0; i < nameChar.length; i++) {
				char c = nameChar[i];
				if (c > 128 && c >= 0x4E00 && c <= 0x9FA5) {
					try {
						sb.append(PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat)[0].charAt(0));
					} catch (BadHanyuPinyinOutputFormatCombination e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					sb.append(c);
				}
			}
		}
		return sb.toString().toLowerCase();
	}

	/**
	 * 汉字转换位汉语拼音，英文字符不变
	 * 
	 * @param str
	 * 
	 * @return
	 */
	public static String StringToSpell(final String str) {
		StringBuffer sb = new StringBuffer();
		if (StringUtils.isNotBlank(str)) {
			char[] nameChar = str.toCharArray();
			HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
			defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);
			defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
			for (int i = 0; i < nameChar.length; i++) {
				char c = nameChar[i];
				if (nameChar[i] > 128 && c >= 0x4E00 && c <= 0x9FA5) {
					try {
						sb.append(PinyinHelper.toHanyuPinyinStringArray(c, defaultFormat)[0]);
					} catch (BadHanyuPinyinOutputFormatCombination e) {
						e.printStackTrace();
					}
				} else {
					sb.append(c);
				}
			}
		}
		return sb.toString().toLowerCase();
	}
}
