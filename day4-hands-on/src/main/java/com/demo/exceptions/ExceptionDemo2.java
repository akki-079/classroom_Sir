package com.demo.exceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemo2 {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("demo.txt");

			fis.read();

		} catch (FileNotFoundException e) {
			System.out.println("File not found..");
		} catch (IOException e) {

			System.out.println("File not found..");
		} finally {
			try {
				System.out.println("Finally executes...");
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("The normal flow resumed..");

	}

}
