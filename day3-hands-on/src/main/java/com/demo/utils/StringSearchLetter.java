package com.demo.utils;

public class StringSearchLetter {

	public static void main(String[] args) {
		String input = " AxBndtyTxtzU";
		// char l='t';
		String sc = "t";
		char l = sc.trim().toLowerCase().toCharArray()[0];

		char[] chars = input.trim().toLowerCase().toCharArray();
		int count = 0;

		for (char c : chars) {
			if (c == l) {
				count++;
			}
		}
		System.out.println(l + " appeard for " + count + " times");
		
		//reset the counter
		count=0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == l) {
				count++;
			}
		}

		System.out.printf("%c appeard for %d times",l,count);

	}

}
