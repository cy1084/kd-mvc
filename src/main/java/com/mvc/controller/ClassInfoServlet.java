package com.mvc.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.ClassInfoRepository;


public class ClassInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ClassInfoRepository ciRepo=new ClassInfoRepository();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Map<String,String>> classInfoList=ciRepo.selectClassInfoList();
		request.setAttribute("classInfoList", classInfoList); //classInfoList를 밑에 path 경로의 jsp로 보내줌
		String path="/WEB-INF/views/class-info/class-info-list.jsp";
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request, response); //forward 됐으므로 밑에 어떤 print.out이 나오든 무시됨!
		
		
		
		
	
	
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
