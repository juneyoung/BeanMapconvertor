package org.owls.convertor.bean2map.test;

import java.util.Map;

import org.owls.convertor.bean2map.Convertor;

public class Test {
	private static Map<String,Object> bean2MapTest (Convertor convertor) throws Exception{
		ABean aBean = new ABean();
		aBean.setAddr("경기도 성남시");
		aBean.setName("Thinker");
		aBean.setId(10);
		Map<String, Object> aMap = convertor.convert2Map(aBean);
		return aMap;
	}
	
	private static Object map2BeanTest(Convertor convertor, Map<String, Object> aMap) throws Exception{
		return convertor.conver2Bean(aMap, ABean.class);
	}
	
	public static void main(String[] args)  throws Exception {
		Convertor convertor = Convertor.getInstance();
		Map<String, Object> aMap = bean2MapTest(convertor);
		//System.out.println(aMap);
		Object aObj = map2BeanTest(convertor, aMap);
		System.out.println(aObj.getClass().getName());
		System.out.println(aObj.toString());
	}
}
