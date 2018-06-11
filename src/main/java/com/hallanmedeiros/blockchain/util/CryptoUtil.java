package com.hallanmedeiros.blockchain.util;

import java.security.MessageDigest;

public class CryptoUtil {
	
		/**
		 * Aplica o SHA-256 em uma entrada 
		 * @param input String de entrada
		 * @return entrada com SHA-256
		 */
		public static String applySha256(String input){		
			try {
				
				MessageDigest digest = MessageDigest.getInstance("SHA-256");	        
				byte[] hash = digest.digest(input.getBytes("UTF-8"));	        
				
				StringBuffer hexString = new StringBuffer();
				for (int i = 0; i < hash.length; i++) {
					String hex = Integer.toHexString(0xff & hash[i]);
					if(hex.length() == 1) hexString.append('0');
					hexString.append(hex);
				}
				return hexString.toString();
			}
			catch(Exception e) {
				throw new RuntimeException(e);
			}
		}	

}
