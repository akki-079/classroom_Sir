package com.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOfInt {

	public static void main(String[] args) {

		List<Integer> numList = Arrays.asList(2, 5, 7, 8, 4, 34, 24, 53, 78, 90, 87, 99);

		numList.stream().filter(x -> x % 2 == 0).forEach(System.out::println);

		List<Integer> evens = numList.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());

		// find all the odd numbers and print
		// find all the numbers >24

		long count = numList.stream().filter(x -> x % 2 == 0).count();

		System.out.println(count);

		int sum = numList.stream().filter(x -> x % 2 == 0).mapToInt(x -> x.intValue()).sum();

		// System.out.println(numList.stream().mapToInt(x->x.intValue()).reduce(0,(x,y)->{System.out.println(x+"+"+y+"
		// = "+(x+y));return x+y;}));

		numList.parallelStream().mapToInt(x -> x.intValue()).reduce(0, (x, y) -> x + y);

	}

}
