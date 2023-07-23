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

public class MovieInfoRepository {
	public List<Map<String, String>> selectMovieInfoList() {
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb//localhost:3306/kd";
		String user = "root";
		String pwd = "kd1824java";

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		List<Map<String, String>> movieInfoList = new ArrayList<>();

		try {
			Connection con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM MOVIE_INFO WHERE 1=1";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Map<String, String> movieInfo = new HashMap<>();
				movieInfo.put("miNum", rs.getString("MI_NUM"));
				movieInfo.put("miName", rs.getString("MI_NAME"));
				movieInfo.put("miDesc", rs.getString("MI_DESC"));
				movieInfoList.add(movieInfo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movieInfoList;

	}
	
	public Map<String,String> selectMovieInfo(String miNum){
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb//localhost:3306/kd";
		String user = "root";
		String pwd = "kd1824java";
		
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con;
		try {
			con = DriverManager.getConnection(url, user, pwd);
			String sql = "SELECT * FROM MOVIE_INFO WHERE MI_NUM=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, miNum);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Map<String,String> movieInfo=new HashMap<>();
				movieInfo.put("miNum",rs.getString("MI_NUM"));
				movieInfo.put("miName",rs.getString("MI_NAME"));
				movieInfo.put("miDesc",rs.getString("MI_DESC"));
				return movieInfo;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
