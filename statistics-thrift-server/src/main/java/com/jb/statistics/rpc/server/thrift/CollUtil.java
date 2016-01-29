package com.jb.statistics.rpc.server.thrift;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class CollUtil<T> {
	private Random random = new Random();

	public static boolean empty(List<?> list) {
		return list == null || list.size() == 0;
	}

	public static boolean notEmpty(List<?> list) {
		return !empty(list);
	}

	public static boolean empty(Map<?, ?> map) {
		return map == null || map.size() == 0;
	}

	public static boolean notEmpty(Map<?, ?> map) {
		return !empty(map);
	}

	public static boolean empty(Set<?> set) {
		return set == null || set.size() == 0;
	}

	public static boolean notEmpty(Set<?> set) {
		return !empty(set);
	}

	public List<T> randomList(List<T> oldList) {
		random.setSeed(System.currentTimeMillis());
		if (CollUtil.empty(oldList)) {
			return null;
		}
		List<T> list = new ArrayList<T>();
		while (oldList.size() > 0) {
			list.add(oldList.remove(random.nextInt(oldList.size())));
		}

		return list;
	}

	// public static List subList(List list, int size) {
	// if (isNotEmpty(list) && list.size() > size) {
	// return list.subList(0, size);
	// } else {
	// return list;
	// }
	// }
	//
	// public static List subListFromEnd(List list, int size) {
	// if (isNotEmpty(list) && list.size() > size) {
	// return list.subList(list.size() - size , list.size() );
	// } else {
	// return list;
	// }
	// }
	
	public static List cuteListFromHead(List list, int size) {
		if (list != null && list.size() > size) {
			return list.subList(list.size() - size, list.size());
		}
		return list;
	}

	public static List cuteListFromTail(List list, int size) {
		if (list != null && list.size() > 0) {
			return list.subList(0, size);
		}
		return list;
	}
}
