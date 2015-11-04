package org.owls.convertor.bean2map;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Convertor {
	
	private final String TYPE_SET = "set";
	private final String TYPE_GET = "get";
	
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
			if(methodName.startsWith(TYPE_GET)){
				methodName = methodName.substring(3, methodName.length()).toLowerCase();
				ret.put(methodName, method.invoke(someBean, new Object[0]));
			}
		}
		return ret;
	}
	
	@SuppressWarnings("rawtypes")
	public Object conver2Bean(Map<String, Object> map, Class beanClass) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Iterator<String> iter = map.keySet().iterator();
		Object beanInstance = beanClass.newInstance();
		Map<String, Method> methodMapList = getMethodMap(TYPE_SET, beanClass);
		while(iter.hasNext()){
			String key = iter.next();
			Object value = map.get(key);
			Method setMethod = methodMapList.get(key);
			setMethod.invoke(beanInstance, value);
		}
		return beanClass.cast(beanInstance); 
	}
	
	@SuppressWarnings("rawtypes")
	private Map<String, Method> getMethodMap(String type, Class beanClass){
		Map<String, Method> methodMap = new HashMap<String,Method>();
		for(Method method : beanClass.getDeclaredMethods()) {
			String methodName = method.getName();
			if(methodName.startsWith(type)){
				methodName = methodName.substring(3, methodName.length()).toLowerCase();
				methodMap.put(methodName, method);
			}
		}
		return methodMap;
	}
};