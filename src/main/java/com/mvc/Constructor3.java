package com.mvc;

public class Constructor3 extends Object {
	public Constructor3() {
		super();//Object 가리키는 super! 
		//모든 '기본 생성자'에는 super가 생략되어 있는 것!
		//파라미터를 가지고 있는 생성자의 경우 super가 자동으로 만들어지지 않으므로 super를 정의해야 함!

	
	}
}

class Exam {
	public static void main(String[] args) {
		new Constructor3();

	}

}
