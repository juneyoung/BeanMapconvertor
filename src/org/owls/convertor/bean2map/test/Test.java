package org.owls.convertor.bean2map.test;

import java.util.Map;

import org.owls.convertor.bean2map.Convertor;

public class Test {
	public static void main(String[] args)  throws Exception {
		Convertor convertor = Convertor.getInstance();
		ABean aBean = new ABean();
		aBean.setAddr("경기도 성남시");
		aBean.setName("Thinker");
		aBean.setId(10);
		Map<String, Object> aMap = convertor.convert2Map(aBean);
		System.out.println(aMap);
	}
}
