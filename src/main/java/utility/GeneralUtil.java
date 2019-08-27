package utility;

import java.util.*;

public class GeneralUtil {

	public static <K, V> K getKeyByValue(Map<K, V> map, V value) {

		for (Map.Entry<K, V> entry : map.entrySet()) {
			if (value.equals(entry.getValue())) {
				return entry.getKey();
			}
		}
		return null;

	}

	public static <K, V> List<K> getKeysByValue(Map<K, V> map, V value) {
		List<K> keys = new LinkedList<>();
		for (Map.Entry<K, V> entry : map.entrySet()) {
			if (value.equals(entry.getValue())) {
				keys.add(entry.getKey());
			}
		}
		return keys;
	}

}
