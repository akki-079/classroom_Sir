package com.demo.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListOfCharacters {

	public static void main(String[] args) {
		List<Character> chars=new ArrayList<>();
		
		chars.add('C');
		chars.add('A');
		chars.add('D');
		chars.add('E');
		chars.add('G');
		chars.add('F');
		chars.add('R');
		chars.add('T');
		
		System.out.println(chars);
		
		//NumSorter sorter=new NumSorter();
		chars.sort(new CharSorter());
		System.out.println(chars);

	}

}

class CharSorter implements Comparator<Character>{
	
	@Override
	public int compare(Character o1, Character o2) {
		
		return o2.charValue()-o1.charValue();
	}
}
