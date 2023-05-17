package com.trangile.lms.integration.common.cryptography;

import java.security.Key;
import java.util.stream.Stream;

import javax.crypto.Cipher;

public class TripleDESEncryption implements IEncryption {
	
	 private Cipher cipher;
	    String encodedStr;
	    String decodedStr;


		@Override
		public String Encrypt(String data, Key[] keys)  {
			try {
				if(keys !=null && keys.length>0) {
					if(keys.length == 1) {
						 byte[] dataInBytes = data.getBytes();
					        cipher = Cipher.getInstance("DES/CBC/NoPadding");
					        cipher.init(Cipher.ENCRYPT_MODE, keys[0]);
					        byte[] encryptedBytes = cipher.doFinal(dataInBytes);
					        encodedStr = encode(encryptedBytes);
					       	
					}
//					else {
//						//if keys array have more data
//						// encryptionCipher.init(Cipher.ENCRYPT_MODE, keys[0]);
//					}
				}
				 return encodedStr;
				
			}catch(Exception e) {
				System.out.println("Exception "+e.getMessage());
				return null;	
			}	
		}

		@Override
		public String Decrypt(String code, Key[] keys) {
			try {
				if(keys !=null && keys.length>0) {
					if(keys.length == 1) {
						byte[] dataInBytes = code.getBytes();
				        cipher = Cipher.getInstance("AES/GCM/NoPadding");
				        cipher.init(Cipher.DECRYPT_MODE, keys[0]);
				        byte[] decryptedBytes = cipher.doFinal(dataInBytes);
				        decodedStr = decode(decryptedBytes);
					}
//					else {
//						//if keys array have more data
//						// encryptionCipher.init(Cipher.ENCRYPT_MODE, keys[0]);
//					}
					}
				return decodedStr;
				
				
			}catch (Exception e) {
				System.out.println("Exception "+e.getMessage());
				return null;
			}
		}


	@Override
	public byte[] Encrypt(byte[] data, byte[][] keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] Decrypt(byte[] code, byte[][] keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream Encrypt(Stream data, byte[][] keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stream Decrypt(Stream code, byte[][] keys) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String encode(byte[] data) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decode(byte[] data) {
		// TODO Auto-generated method stub
		return null;
	}

	

	

}
