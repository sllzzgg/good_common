package com.dshl.commons.utlis;

import java.util.Date;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.spec.IvParameterSpec;
/**
 * 加密算法
 * @author Noah
 *
 */
public class TripleDESUtil {

	public byte[]  encryption(byte[] key, byte[] message){

		/*Long iv = new Long(new Date().getTime());

		Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");

		SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");

		SecretKey secretKey = skf.generateSecret(new DESedeKeySpec(key));

		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);

		cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

		byte[] result = cipher.doFinal(message);*/
		return null;

	} 

	/**
	 * 解密算法
	 * @param key
	 * @param iv
	 * @param message
	 * @return
	 * @throws Exception
	 */
	public byte[] decode(byte[] key, byte[] iv, byte[] message) throws Exception{
		Cipher cipher = Cipher.getInstance("DESede/CBC/PKCS5Padding");
		SecretKeyFactory skf = SecretKeyFactory.getInstance("DESede");
		SecretKey secretKey = skf.generateSecret(new DESedeKeySpec(key));
		IvParameterSpec ivParameterSpec = new IvParameterSpec(iv);
		cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
		byte[] result = cipher.doFinal(message);
		return result;
	}

}
