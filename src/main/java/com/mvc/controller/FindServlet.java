package com.mvc.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int rNum;	//해당 메모리가 죽을 때까지 유지하기 위해 멤버 변수 선언
	

	public FindServlet() {
		Random r = new Random();
		rNum = r.nextInt(100) + 1;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) //doGet이 호출될 때마다 메모리를 계속 생성할 필요 없으므로 멤버 변수 선언 제대로 생각하기!
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx + 1);
		String path="/WEB-INF/views/";
		
		if("find".equals(uri)) { //form 태그 주소
			path += "find/find.jsp";
		}else if("check".equals(uri)) {
			int count=0;
			boolean correct=false;		
			int num=Integer.parseInt(request.getParameter("num")); //parameter는 내가 set 할 수 없음, form 태그의 name 값으로! 
			while(!correct) {
				if(rNum==num) {
					count++;
				}
				System.out.println(count+"번 맞췄다!");
			}
			path+="find/result.jsp";
		}

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
