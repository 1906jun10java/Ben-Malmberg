package com.revature.strings;

public class StringMethods {

	public static String reversal(String string) {

		char[] dArray = new char[string.length()];
		char[] cArray = new char[string.length()];

		cArray = string.toCharArray();

		for (int i = 0; i < cArray.length; i++) {

			if (i == 0) {
				dArray[i] = cArray[cArray.length - 1];
			} else {
				dArray[i] = cArray[cArray.length - i - 1];
			}
		}

		string = String.valueOf(dArray);

		return string;

	}

	public static boolean palendrome(String string) {

		boolean test = false;

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == string.charAt(string.length() - i - 1)) {
				if (i == string.length() - i - 1) {
					test = true;
				}
			} else {
				test = false;
			}

		}
		return test;
	}

	public static String recursiveReversal(String string) {
		char[] dArray = new char[string.length()];
		char[] cArray = new char[string.length()];
		int i = 0;
		cArray = string.toCharArray();

		if (cArray[0] == cArray[i]) {
			dArray[i] = cArray[cArray.length - 1];
		}
		
		string = String.valueOf(dArray);
		return recursiveReversal(string);
	}

}
