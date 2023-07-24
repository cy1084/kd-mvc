package com.mvc.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	// 메인 메소드 실행 전 무언가를 기억하고 싶으면 static 사용하면 됨!!
	private static final String DRIVER_NAME = "org.mariadb.jdbc.Driver";
	private static final String URL = "jdbc:mariadb://localhost:3306/kd";
	private static final String USER = "root";
	private static final String PWD = "kd1824java";

	// 이것도 메인 메소드 실행 전 기억하기 위해 static 영역에 선언(main 메소드 이전에 실행)
	static {
		try {
			Class.forName(DRIVER_NAME);
			//System.out.println("안녕");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getCon() {
		try {
			return DriverManager.getConnection(URL, USER, PWD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		//System.out.println("난 안녕 뒤에 나옴");
		Connection con=getCon();
		System.out.println(con);
	}

}
