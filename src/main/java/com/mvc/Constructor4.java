package com.mvc;

class ParamConstructor {
	ParamConstructor() {

	}

	ParamConstructor(String str) {
		//this.str=str;
		//다시 해보기
	}
}

public class Constructor4 extends ParamConstructor {
	public Constructor4() {
		super(); //ParamConstructor을 가리키는 자동으로 만들어진 super
		
	}

class Exam {
	public static void main(String[] args) {
		new Constructor4();

		}
	}

}
