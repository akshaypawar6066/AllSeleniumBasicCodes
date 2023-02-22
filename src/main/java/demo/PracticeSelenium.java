package demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeSelenium extends Demo {

	public static void main(String[] args) {

		int a[] = new int[5];
		a[0] = 10;
		a[1] = 25;
		a[2] = 656;
		a[3] = 6494;
		a[4] = 5965;
		// a[5]=10;
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
			if (a[i] != 10) {
				System.out.println("Hello");
			}
		}

		String[] str = { "hsgu", "shvjs", "jshcj" };
		String name[] = { "Akshay", "Pawar" };
		for (int i = 0; i < str.length; i++) {

			System.out.println(str[i]);

		}

		for (String s : name) {
			System.out.println(s);
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0) {
				System.out.println(a[i]);
			}

		}

		ArrayList<String> arrayList = new ArrayList<String>();
		arrayList.add("India");
		arrayList.add("Is");
		arrayList.add("My");
		arrayList.add("Country");

		for (int i = 0; i < arrayList.size(); i++) {
			System.out.println(arrayList.get(i));
		}

		System.out.println("--------------------");

		for (String value : arrayList) {
			System.out.println(value);
		}

		System.out.println(arrayList.contains("India"));

		String[] arry = { "jdhgghcj", "hudfhud", "hdsgf" };
		List NameArray = Arrays.asList(arry);

	}
}
