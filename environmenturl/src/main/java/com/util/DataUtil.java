package com.util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.api.StaticDataServiceImpl;
import com.model.StaticData;

public class DataUtil {
	
	private static final Logger logger = Logger.getLogger(DataUtil.class);
	
	@Autowired
	StaticDataServiceImpl staticDataServiceImpl;
	
	static private byte[] KEY = {1, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 2, 4, 0};
	
	public List<String> getConfigTypes(String config_type){
		Map<String,List<String>> configTypeMap = new HashMap<String,List<String>>();
		try{
			List<StaticData> staticDataList = staticDataServiceImpl.getAllStaticData();
			for(StaticData staticData : staticDataList){
				if(configTypeMap.containsKey(staticData.getData_type())){
					configTypeMap.get(staticData.getData_type()).add(staticData.getData_value());
				}else{
					List<String> list = new ArrayList<String>();
					list.add(staticData.getData_value());
					configTypeMap.put(staticData.getData_type(),list);
				}
			}
			logger.debug("Map Data : "+configTypeMap);
		}catch(Exception exception){
			logger.error("Exception Occured : "+exception.getStackTrace());
		}
		logger.debug("Config Type List : "+configTypeMap.get(config_type)+" For : "+config_type);
		return configTypeMap.get(config_type);
	}
	
	public static String decrypt(String encryptedText) {
		String plainText = null;
		byte[] desByte = AESCryptor(Base64.decodeBase64(encryptedText),Cipher.DECRYPT_MODE);
		if (desByte != null) {
			plainText = new String(desByte).trim();
		}
		System.out.println(plainText);
		return plainText;
	}

	// direction = Cipher.DECRYPT_MODE or Cipher.ENCRYPT_MODE
	static final public byte[] AESCryptor(byte[] inByte, int direction) {
		byte[] result = null;
		try {
			SecretKeySpec skeySpec = new SecretKeySpec(KEY, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(direction, skeySpec);
			result = cipher.doFinal(inByte);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}

	public static String encrypt(String plainText) {
		return Base64.encodeBase64URLSafeString(AESCryptor(plainText.getBytes(), Cipher.ENCRYPT_MODE));
	}
}
