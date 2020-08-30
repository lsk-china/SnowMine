package com.lsk.testmod.utils;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CollectionUtil {
	public static <T> void printCollection(Collection<T> coll){
		StringBuilder builder = new StringBuilder();
		if (coll instanceof List){
			for(T t : coll){
				builder.append(t.toString());
				builder.append(",");
			}
		}else if (coll instanceof Map){
			for(Map.Entry<?,?> entry : ((Map<?,?>)coll).entrySet()){
				builder.append(entry.getKey().toString()+" : "+entry.getValue().toString());
				builder.append(",");
			}
		}else{
			throw new RuntimeException(new UnsupportedOperationException("Unsupported collection!"));
		}
		builder.deleteCharAt(builder.length()-1);
		System.out.println(builder.toString());
	}
}
