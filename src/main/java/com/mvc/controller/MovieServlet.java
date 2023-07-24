package com.mvc.controller;

import java.io.IOException;
import java.util.HashMap;
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
	private MovieInfoRepository miRepo = new MovieInfoRepository();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/");
		uri = uri.substring(idx + 1);
		String path = "/WEB-INF/views/";

		if ("list".equals(uri)) {
			path += "movie-info/list.jsp";
			request.setAttribute("movieInfoList", miRepo.selectMovieInfoList());
		} else if ("view".equals(uri)) {
			path += "movie-info/view.jsp";
			String miNum = request.getParameter("miNum");
			Map<String, String> movieInfo = miRepo.selectMovieInfo(miNum);
			request.setAttribute("movieInfo", movieInfo);
		} else if ("insert".equals(uri)) {
			path += "movie-info/insert.jsp";
		} else if ("update".equals(uri)) {
			path += "movie-info/update.jsp";
			String miNum = request.getParameter("miNum");
			Map<String, String> movieInfo = miRepo.selectMovieInfo(miNum);
			request.setAttribute("movieInfo", movieInfo);
		} else if ("delete".equals(uri)) {
			path += "movie-info/delete.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uri = request.getRequestURI();
		int idx = uri.lastIndexOf("/") + 1;
		uri = uri.substring(idx);
		String path = "/WEB-INF/views/common/msg.jsp";

		if ("insert".equals(uri)) {
			String miTitle = request.getParameter("miTitle");
			String miDesc = request.getParameter("miDesc");
			String miGenre = request.getParameter("miGenre");
			String miCredat = request.getParameter("miCredat");
			String miCnt = request.getParameter("miCnt");

			Map<String, String> param = new HashMap<>();
			param.put("miTitle", miTitle);
			param.put("miDesc", miDesc);
			param.put("miGenre", miGenre);
			param.put("miCredat", miCredat);
			param.put("miCnt", miCnt);
			int result = miRepo.insertMovieInfo(param);
			request.setAttribute("msg", "영화 등록에 실패하였습니다.");
			request.setAttribute("url", "/movie-info/list");
			if (result == 1) {
				request.setAttribute("msg", "영화 등록에 성공하였습니다.");
				request.setAttribute("url", "/movie-info/list");
			}

		} else if ("update".equals(uri)) {
			Map<String, String> param = new HashMap<>();
			param.put("miTitle", request.getParameter("miTitle"));
			param.put("miDesc", request.getParameter("miDesc"));
			param.put("miGenre", request.getParameter("miGenre"));
			param.put("miCredat", request.getParameter("miCredat"));
			param.put("miCnt", request.getParameter("miCnt"));

			int result = miRepo.updateMovieInfo(param);
			request.setAttribute("msg", "영화 수정에 실패하였습니다.");
			request.setAttribute("url", "/movie-info/update?miNum=" + request.getParameter("miNum"));

			if (result == 1) {
				request.setAttribute("msg", "영화 수정에 성공하였습니다.");
				request.setAttribute("url", "movie-info/list");
			}
		} else if ("delete".equals(uri)) {
			String miNum = request.getParameter("miNum");
			int result = miRepo.deleteMovieInfo(miNum);
			request.setAttribute("msg", "영화 삭제를 실패하였습니다.");
			request.setAttribute("url", "/movie-info/view?miNum=" + request.getParameter("miNum"));

			if (result == 1) {
				request.setAttribute("msg", "영화 삭제를 성공하였습니다.");
				request.setAttribute("url", "/movie-info/list");
			}
		}

		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

}
