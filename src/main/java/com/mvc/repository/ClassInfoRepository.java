package com.mvc.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClassInfoRepository {
	public List<Map<String,String>> selectClassInfoList() {
		String driverName="org.mariadb.jdbc.Driver";
		String url="jdbc:mariadb://localhost:3306/kd";
		String user="root";
		String pwd="kd1824java";
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		List<Map<String,String>> classInfoList=new ArrayList<>();
		Map<String,String> classInfo=new HashMap<>();
		try {
			Connection con=DriverManager.getConnection(url,user,pwd);		
		
			String sql="SELECT * FROM CLASS_INFO WHERE 1=1";
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("CI_NUM"));
				System.out.println(rs.getString("CI_NAME"));
				System.out.println(rs.getString("CI_DESC"));
				classInfoList.add(classInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classInfoList;
	}
	
	public static void main(String[] args) {
		ClassInfoRepository ciRepo=new ClassInfoRepository(); //실행하기 위해 메모리 생성
		List<Map<String,String>> classInfoList=ciRepo.selectClassInfoList();
		
		
		for(Map<String,String> classInfo : classInfoList) {
			System.out.println(classInfoList);
		}
		
	}

}

