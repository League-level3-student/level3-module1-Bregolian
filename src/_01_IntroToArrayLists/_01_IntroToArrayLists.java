package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		String[] stringList=new String[5];
		//2. Add five Strings to your list
		stringList[0]="Hi";
		stringList[1]="Hello";
		stringList[2]="Hello Again";
		stringList[3]="Yes";
		stringList[4]="No";
		//3. Print all the Strings using a standard for-loop
		for (int i = 0; i < stringList.length; i++) {
			System.out.println(stringList[i]);
		}
		
		//4. Print all the Strings using a for-each loop
		for (String string : stringList) {
			System.out.println(string);
		}
		//5. Print only the even numbered elements in the list.
		int forLength = stringList.length;
		if (stringList.length%2==1) {
			forLength++;
		}
		for (int i = -1; i < (forLength/2)-1; i++) {
			i++;
			System.out.println(stringList[i]);
		}
		//6. Print all the Strings in reverse order.
		forLength = stringList.length;
		for (int i = stringList.length-1; i > 0; i--) {
			System.out.println(stringList[i]);
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for (int i = 0; i < stringList.length; i++) {
			if (stringList[i].contains("e")) {
				System.out.println(stringList[i]);
			}
		}
	}
}
