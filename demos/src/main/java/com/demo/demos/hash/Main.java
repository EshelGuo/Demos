package com.demo.demos.hash;

import java.util.Objects;

import javax.sound.midi.Soundbank;

/**
 * <br>createBy G
 * <br>createTime: 2021/6/10 16:52
 * <br>desc:
 */
public class Main {

	int age = 0;
	public static void main(String args[]){
		Main main = new Main();
		Main main1 = new Main();
		System.out.println(main == main1);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Main main = (Main) o;
		return age == main.age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age);
	}
}