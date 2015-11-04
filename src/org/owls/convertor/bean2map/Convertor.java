package org.owls.convertor.bean2map;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Convertor {
	
	private Convertor (){;}
	private static class LazyLoader {
		private static final Convertor INSTANCE = new Convertor(); 
	}
	
	public static Convertor getInstance (){
		return LazyLoader.INSTANCE;
	}
	
	public Map<String, Object> convert2Map(Object someBean) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Map<String, Object> ret 
			= new HashMap<String, Object>();
		Class<? extends Object> clz = someBean.getClass();
		
		for(Method method : clz.getDeclaredMethods()) {
			String methodName = method.getName();
			if(methodName.startsWith("get")){
				methodName = methodName.substring(3, methodName.length()).toLowerCase();
				ret.put(methodName, method.invoke(someBean, new Object[0]));
			}
		}
		return ret;
	}
};