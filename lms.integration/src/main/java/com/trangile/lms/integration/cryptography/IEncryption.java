package com.trangile.lms.integration.cryptography;

import java.security.Key;
import java.util.stream.Stream;

public interface IEncryption  {

	String Encrypt(String data, Key[] keys) throws Exception;
    String Decrypt(String code, Key[] keys)throws Exception;
    byte[] Encrypt(byte[] data, byte[][] keys);
    byte[] Decrypt(byte[] code, byte[][] keys);
    Stream Encrypt(Stream data, byte[][] keys);
    Stream Decrypt(Stream code, byte[][] keys);
    
    String encode(byte[] data);
    String decode(byte[] data);
}
