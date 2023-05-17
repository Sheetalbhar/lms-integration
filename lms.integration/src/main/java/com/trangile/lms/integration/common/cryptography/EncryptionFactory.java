package com.trangile.lms.integration.common.cryptography;

public class EncryptionFactory {
	

	  public static IEncryption GetEncryption()
	 {
		
		 EncryptionType type = EncryptionType.SHA512;
	     switch (type)
	     {
	         case MD5:
	            return new HashEncryption(HashEncryption.HashType.MD5);
	         case SHA1:
	             return new HashEncryption(HashEncryption.HashType.SHA1);
	         case SHA256:
	             return new HashEncryption(HashEncryption.HashType.SHA256);
	         case SHA512:
	             return new HashEncryption(HashEncryption.HashType.SHA512);
	         case AES:
	             return new AESEncryption();
	         case TripleDES:
	             return new TripleDESEncryption();
	         default:
	           return null;
	     }
	 }
}
