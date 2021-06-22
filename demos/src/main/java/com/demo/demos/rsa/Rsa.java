package com.demo.demos.rsa;

import java.math.BigInteger;
import java.util.Random;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/10 10:58
 * <br>desc:
 */
public class Rsa {
//RSAMultiPrimePrivateCrtKey
	// 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 51

	//最大公约数
	private int gcd(int m, int n) {
		while (true) {
			if ((m = m % n) == 0)
				return n;
			if ((n = n % m) == 0)
				return m;
		}
	}

	/*
	  通过扩展欧几里得算法求得x的逆元x'
	  x = kx', b = k(a, m)
	  所以要求地 x = (b / gcd(a, m)) * x'
	 */
	private int linearCongruence(int a, int b, int m) {
		if (b % gcd(a, m) != 0)
			return -1;
		int result = (b / gcd(a, m)) * extendedEuclid(a, m);
		if (result < 0)
			result += m;
		return result;
	}

	private int extendedEuclid(int a, int b) {
		int x = 0, y = 1, lastX = 1, lastY = 0, temp;

		if (a < b) {
			temp = a;
			a = b;
			b = temp;
		}

		while (b != 0) {
			int q = a / b, r = a % b;
			a = b;
			b = r;

			temp = x;
			x = lastX - q * x;
			lastX = temp;

			temp = y;
			y = lastY - q * y;
			lastY = temp;
		}
		return lastY;
	}

	public RsaKey generateKey() {
		//欧拉函数
		//如果n是质数的某一个次方
		// -- φ(P^k) = P^k - P^k-1

		//如果n可以分解成两个互质的整数之积
		//  n = p1 × p2
		//　φ(n) = φ(p1p2) = φ(p1)φ(p2)

		//2^3
		//p=2
		//2^2
		//1 * 2, 2 * 2, 3 * 2 , 4 * 2

		//随意选择两个大的素数P和Q，P≠Q
		int P = 997;
		int Q = 857;
		//计算N=PQ
		int N = P * Q;
		int r = (P - 1) * (Q - 1);
		//质数 e 一般为写死的
		int e = 65537;
		//ed ≡ 1(mod r)
		// ed - 1 = kr
		// ed -kr = 1
		// ed + (-k) * r = 1
		// 令x=d, y = -k
		// 则 ex + ry = 1
		// d
		//XXXXXXXX d = (kr + 1) / e ERROR
		int d = linearCongruence(e, 1, r);
		//将n和e封装成公钥，n和d封装成私钥。
		return new RsaKey(N, e, d);
	}

	public String encode(PublicKey key, String src) {
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < src.length(); i++) {
			if (i != 0) {
				builder.append(',');
			}
			int m = src.charAt(i);
			// m^e ≡ c (mod n)
			// c = m^e % n
			BigInteger $m = new BigInteger(String.valueOf(m));
			BigInteger $n = new BigInteger(String.valueOf(key.n));
			BigInteger c = $m.pow(key.e).mod($n);
			builder.append(Integer.toHexString(c.intValue()));
		}
		return builder.toString();
	}

	public String decode(PrivateKey key, String src) {
		StringBuilder builder = new StringBuilder();
		String[] array = src.split(",");
		for (String s : array) {
			// c^d ≡ m (mod n)
			// m = c^d % n
			int c = Integer.parseInt(s, 16);
			BigInteger $c = new BigInteger(String.valueOf(c));
			BigInteger $n = new BigInteger(String.valueOf(key.n));
			BigInteger $m = $c.pow(key.d).mod($n);

			char m = (char) $m.intValue();
			builder.append(m);
		}
		return builder.toString();
	}
}