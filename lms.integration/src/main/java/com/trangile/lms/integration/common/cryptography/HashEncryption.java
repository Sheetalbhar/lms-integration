package com.trangile.lms.integration.common.cryptography;

import java.security.Key;
import java.util.stream.Stream;

import javax.crypto.Cipher;


public class HashEncryption implements IEncryption {
//	HashAlgorithm hashAlgorithm;
	//HashAlgorithm hashAlgorithm = new HashAlgorithm();
	 private Cipher cipher;
	    String encodedStr;
	    String decodedStr;

   
	public HashEncryption(HashType hashType)
    {
        switch (hashType)
        {
//            case MD5:
//                hashAlgorithm = new MD5CryptoServiceProvider();
//                break;
//            case SHA1:
//                hashAlgorithm = new SHA1CryptoServiceProvider();
//                break;
//            case SHA256:
//                hashAlgorithm = new SHA256CryptoServiceProvider();
//                break;
//            case SHA512:
//                hashAlgorithm = new SHA512CryptoServiceProvider();
//                break;
        }
    }
	
	public enum HashType
    {
        MD5,
        SHA512,
        SHA256,
        SHA1,
    }

	@Override
	public String Encrypt(String data, Key[] keys) throws Exception {
		try {
			if(keys !=null && keys.length>0) {
				if(keys.length == 1) {
					 byte[] dataInBytes = data.getBytes();
				        cipher = Cipher.getInstance("DES/CBC/NoPadding");
				        cipher.init(Cipher.ENCRYPT_MODE, keys[0]);
				        byte[] encryptedBytes = cipher.doFinal(dataInBytes);
				        encodedStr = encode(encryptedBytes);
				       	
				}
//				else {
//					//if keys array have more data
//					// encryptionCipher.init(Cipher.ENCRYPT_MODE, keys[0]);
//				}
			}
			 return encodedStr;
			
		}catch(Exception e) {
			System.out.println("Exception "+e.getMessage());
			return null;	
		}
	}

	@Override
	public String Decrypt(String code, Key[] keys) throws Exception {
		try {
			if(keys !=null && keys.length>0) {
				if(keys.length == 1) {
					byte[] dataInBytes = code.getBytes();
			        cipher = Cipher.getInstance("AES/GCM/NoPadding");
			        cipher.init(Cipher.DECRYPT_MODE, keys[0]);
			        byte[] decryptedBytes = cipher.doFinal(dataInBytes);
			        decodedStr = decode(decryptedBytes);
				}
//				else {
//					//if keys array have more data
//					// encryptionCipher.init(Cipher.ENCRYPT_MODE, keys[0]);
//				}
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
