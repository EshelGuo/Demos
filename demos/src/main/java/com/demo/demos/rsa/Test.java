package com.demo.demos.rsa;

import java.math.BigInteger;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/10 12:33
 * <br>desc:
 */
public class Test {

	public static void main(String args[]){

		Rsa rsa = new Rsa();

		RsaKey rsaKey = rsa.generateKey();

		String ciphertext = rsa.encode(rsaKey.publicKey, "啊哈哈哈!");
		System.out.println(ciphertext);

		String originaltext = rsa.decode(rsaKey.privateKey, ciphertext);
		System.out.println(originaltext);
	}
}