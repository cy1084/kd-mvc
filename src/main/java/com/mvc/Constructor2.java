package com.mvc;

//아빠
class Test {
	public String name;

	public Test(String name) {
		this.name = name;
		this.printName();
	}
	public void printName() {
		System.out.println("아빠 : "+name);
	}
}

//아들
public class Constructor2 extends Test{
	public Constructor2(String name1) {		 
		
		super(name1); //super-> 한 단계 위의 생성자!(Test 생성자)
		//super(); -> class Test에 기본 생성자가 없기 때문에 오류 
		
		//System.out.println(name);	//Test의 내용을 다 기억하고 내려오기 때문에 오류 안남
	}
	public void printName() { //아빠 printName은 그대로 있고 그 위에 아들의 printName이 올라감(오버라이딩)
		super.printName();	//아빠의 printName 호출
		System.out.println("아들 : "+name);
	}
	
}

class Execute2 {
	public static void main(String[] args) {
		Constructor2 c=new Constructor2("황채영"); //생성자 호출
		c.printName(); //아들의 printName 실행
		
		
		
	}

}
