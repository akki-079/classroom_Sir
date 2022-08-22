package com.demo.utils;

import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID (int): ");
		int id = sc.nextInt();
		System.out.println("Enter Name (String): ");
		String name = sc.next();
		System.out.println("Enter Location (String): ");
		String loc = sc.next();

		Person p = new Person(id, name, loc);
		System.out.println(p.getDetails());

	}

}
