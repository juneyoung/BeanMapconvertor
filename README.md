# BeanMapConvertor
#####  Writen by Juneyoung Oh / 04.NOV.2015
Convert Bean class to Map&lt;String, Object> types.<br>

This mini-project provides a convenient method, which convert a Bean to a `Map<String, Object`>.<br>
After converting, Map has fieldName as key and value for value.<br>

The convertor class is designed with singletone. You can get a instance like follow.<br>
```java
Convertor convertor = Convertor.getInstance();
```

It has a method named `convert2Map` with a parameter `Object`.<br>
This method will search `get` method from the instance and invoke that.<br>

Sample code for first Commit.<br>

```java
  public static void main(String[] args)  throws Exception {
		Convertor convertor = Convertor.getInstance();
		ABean aBean = new ABean();
		aBean.setAddr("Orange County");
		aBean.setName("GoodJob!");
		aBean.setId(10);
		Map<String, Object> aMap = convertor.convert2Map(aBean);
		System.out.println(aMap);
	}
```


##### Version control
<div>
<ul>
  <li>2015 11 04 - first commit</li>
<ul>
</div>
##### Language
<div>
<ul>
  <li><a href='../../blob/master/README_KR.md'>한국어(KOR)</br></li>
<ul>
</div>
