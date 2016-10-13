package com.filemanager.smsModule;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.web.client.RestTemplate;

// www.smsapi.com is used and is working fine
public class SmsApi {

	public boolean sendSMS(String smsMessage) {

		RestTemplate restTemplate = new RestTemplate();
		String username = "";
		String password = "";
		password = md5(password);
		String url = "https://api.smsapi.com/sms.do?username=" + username + "&password=" + password + "&details=1&from=Info&to=0040753435566&message=" + smsMessage;

		String s = restTemplate.getForObject(url, String.class);
		System.out.println(s);

		return true;
	}

	private static String md5(String input) {

		String md5 = null;

		if (null == input)
			return null;

		try {

			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");

			// Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());

			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		return md5;
	}
}
