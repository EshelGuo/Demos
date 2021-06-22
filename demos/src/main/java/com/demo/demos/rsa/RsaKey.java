package com.demo.demos.rsa;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/10 12:28
 * <br>desc:
 */
public class RsaKey {
	public final PublicKey publicKey;
	public final PrivateKey privateKey;

	public RsaKey(int n, int e, int d) {
		this.publicKey = new PublicKey(n ,e);
		this.privateKey = new PrivateKey(n ,d);
	}

	@Override
	public String toString() {
		return "n: " + publicKey.n +", e: " + publicKey.e + ", d: " + privateKey.d;
	}
}