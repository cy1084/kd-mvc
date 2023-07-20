package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LottoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> lotto = new ArrayList<>();

	public LottoServlet() {
		Random random = new Random();
		while (lotto.size() < 6) {
			String rNum = random.nextInt(45) + 1 + ""; // 문자열로
			if (lotto.contains(rNum)) {
				lotto.add(rNum);
			}
		}

		// 중복되지 않는 난수 1-45 6개를 만들어 저장
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		int idx = uri.indexOf("/");
		uri = uri.substring(idx + 1);

		String path = "/WEB-INF/views/";
		if ("lotto".equals(uri)) {
			path += "lotto/lotto.jsp";
		} else if ("comp".equals(uri)) { // 값을 입력받는 jsp

			String[] nums = request.getParameterValues("num");
			int result = 0;
			for (String num : nums) {
				if (lotto.contains(num)) {
					result++;
				}
			}
			request.setAttribute("result", result);
			path += "lotto/result.jsp";

			// lotto와 nums 안의 값들을 비교하여 몇 개 맞췄는지 result.jsp로 보내기

		}
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
