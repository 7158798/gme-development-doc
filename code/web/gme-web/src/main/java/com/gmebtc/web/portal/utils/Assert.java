package com.gmebtc.web.portal.utils;

import java.util.List;
import java.util.Map;

/**
 * Assert 断言，用于常用条件的判断
 * 
 * @author Mark version 1.0 2009-6-8
 */
public final class Assert {

	private Assert() {
	}

	public static boolean isNull(Object... objects) {
		if (objects == null)
			return true;
		for (Object o : objects) {
			if (o == null)
				return true;
			if (o.getClass() == String.class) {
				String data = (String) o;
				if (data == null || data.equals("") || data.trim().equals("")
						|| data.equals(" "))
					return true;
			}
		}
		return false;
	}

	public static boolean isListOrMapNull(Object obj){
		if(obj == null){
			return true;
		}
		if(obj instanceof Map){
			 Map map = (Map) obj;
			 if(map.size()==0){
				 return true;
			 }
		}
		if(obj instanceof List){
			List list = (List) obj;
			 if(list.size()==0){
				 return true;
			 }
		}
		return false;
	}
	
	
	public static final boolean isInstance(final Object object,
			final Class<?>... classes) {
		if (isNull(object, classes)) {
			return false;
		}

		for (Class<?> c : classes) {
			if (!isNull(c) && c.isInstance(object)) {
				return true;
			}
		}

		return false;
	}

	public static final boolean equals(final Object left, final Object right) {
		return left == null ? right == null : ((right != null) && left
				.equals(right));
	}

	public static final boolean equals(final Object[] leftArray,
			final Object[] rightArray) {
		if (leftArray == rightArray) {
			return true;
		}

		if (leftArray == null) {
			return (rightArray == null);
		} else if (rightArray == null) {
			return false;
		}

		if (leftArray.length != rightArray.length) {
			return false;
		}

		for (int i = 0; i < leftArray.length; i++) {
			final Object left = leftArray[i];
			final Object right = rightArray[i];
			final boolean equal = (left == null) ? (right == null) : (left
					.equals(right));
			if (!equal) {
				return false;
			}
		}

		return true;
	}
}
