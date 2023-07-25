package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ViewsServlet", urlPatterns = "/views/*") // name의 default는 servlet의 이름!
																// @WebServlet("/views/*") 라고 쓰는 것과 동일 //urlPatterns
																// 복수이기 때문에 url이 여러 개여도 가능!
public class ViewsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PREFIX = "/WEB-INF";
	private static final String SUFFIX = ".jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri= PREFIX + request.getRequestURI() + SUFFIX;
		System.out.println(uri);
		//localhost/views 라고만 입력해도 들어가짐
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
