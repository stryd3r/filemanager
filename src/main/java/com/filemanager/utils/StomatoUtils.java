package com.filemanager.utils;

public class StomatoUtils {

	public static boolean isNullOrEmpty(String input) {

		if (input == null || "".trim().equalsIgnoreCase(input)) {
			return true;
		}

		return false;
	}

	public static boolean isNull(String input) {

		if (input == null) {
			return true;
		}

		return false;
	}
}
