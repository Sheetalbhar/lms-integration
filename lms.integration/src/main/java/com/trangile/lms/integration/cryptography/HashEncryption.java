package com.trangile.lms.integration.cryptography;

import java.security.Key;
import java.util.stream.Stream;


public class HashEncryption implements IEncryption {
//	HashAlgorithm hashAlgorithm;
   
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Decrypt(String code, Key[] keys) throws Exception {
		// TODO Auto-generated method stub
		return null;
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
