package com.mvc.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.repository.MovieInfoRepository;

//view -> controller -> service -> repository(vo) -> db

public class MovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MovieInfoRepository miRepo=new MovieInfoRepository();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		int idx=uri.lastIndexOf("/");
		uri=uri.substring(idx+1);
		String path="/WEB-INF/views/";
		
		if("list".equals(uri)) {
			path+="movie-info/list.jsp";
			request.setAttribute("movieInfoList",miRepo.selectMovieInfoList());
		}else if("view".equals(uri)) {
			String miNum=request.getParameter("miNum");
			Map<String,String> movieInfo=miRepo.selectMovieInfo(miNum);
			request.setAttribute("movieInfo", movieInfo);
			
			path+="movie-info/view.jsp";
		}
		RequestDispatcher rd=request.getRequestDispatcher(path);
		rd.forward(request,response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
