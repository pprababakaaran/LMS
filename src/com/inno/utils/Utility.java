package com.inno.utils;

import java.util.List;

public final class Utility {
	
	public static boolean isEmpty(String value) {
		boolean isEmpty = false;
		if(value == null || value.trim().length() == 0 || "null".equalsIgnoreCase(value)) {
			isEmpty = true;
		}
		return isEmpty;
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean isListEmpty(List list) {
		boolean isEmpty = false;
		if (null == list || list.isEmpty()) {
			isEmpty = true;
		} 
		return isEmpty;
	}
}
