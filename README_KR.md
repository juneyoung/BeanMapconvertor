# BeanMapConvertor
#####  작성자 Juneyoung Oh / 04.NOV.2015
아무 빈이나 Map&lt;String, Object> 형태로 변환합니다.<br>

이 미니 프로젝트는 DB 에서 Map 을 받아와서 Bean 으로 변환하거나 Bean 을 Map으로 변환하는 걸 쉽게 하기 위한 프로젝트입니다.<br>
작업 후에는 Map 에 키로 Bean 의 필드가 들어가고, 값으로 필드의 값이 들어갑니다.<br>

Convertor 클래스가 싱글톤으로 구현되어 있기 때문에 아래와 같은 방법으로 인스턴스를 생성합니다.<br>
```java
Convertor convertor = Convertor.getInstance();
```

Convertor 클래스는 `Object` 하나를 파라미터로 받는 `convert2Map`라는 클래스가 있습니다.<br>
이 메소드는 getter/setter 네이밍룰에 따라 getter 를 찾고 해당 인스턴스에서 그 메소드를 실행하여 Map 에 담습니다.<br>

샘플 코드는 아래와 같습니다.<br>

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


##### 버전 관리
<ul>
  <li>2015 11 04 - 최초커밋</li>
<ul>

