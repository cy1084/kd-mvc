package com.mvc;

//생성자
//-> 메모리가 생성될 때 실행, 단 한번만 실행, 데이터 타입 없음, 클래스 명과 동일, 맨 처음 만들자마자 무언가를 수행해야 할 때 생성자에 선언, 오버로딩 지원, 다른 메소드보다 무조건 위에
public class Constructor {
	// 싱글톤- 몇 번을 만들어도 같음, 하나!

	//Constructor() {// 접근 제어자 default
	//}
	
	public Constructor() {
		//System.out.println("메모리 생성하면 나 실행되겠지?");
		System.out.println(num);
		//test();
	}
	
	public Constructor(int num) {
		//System.out.println("메모리 생성하면 나 실행되겠지?");
		System.out.println(num);
		//test();
		this.num=num;		
	}
	
	public void Constructor() {	//생성자가 아닌 명명 규칙을 어긴 메소드!-> 생성자는 데이터 타입이 없기 때문
		System.out.println("메모리 생성하면 나 실행되겠지?");
		System.out.println(num);
		test();
	}
	int num;
	void test() {
		System.out.println("나 이미 머리 속에 있어서 생성자에서 정상적으로 호출됨!");
	}
	//제대로 실행됨 -> 생성자를 호출할 때 생성자 Constructor 안에 있는 내용은 전체를 한번 파악하고 실행하기 때문에 num과 test()가 System.out.println 아래 있어도 제대로 실행됨
}

class Execute {
	public static void main(String[] args) {
		Constructor c=new Constructor(); //0
		Constructor c1=new Constructor(200); //200
		System.out.println(c1.num); //0 -> 한번 출력되면 다시 0으로!/ this.num=num 하면 200이 출력

	}

}
