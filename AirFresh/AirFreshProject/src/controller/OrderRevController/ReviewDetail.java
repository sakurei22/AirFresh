package controller.OrderRevController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.ModelReviewPurDto;
import projectutil.ProjectUtil;
import singleton.singleton;

@WebServlet("/reviewDetail")
public class ReviewDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("reviewDetail 도착");
		req.setCharacterEncoding("utf-8");
		
		String seq = req.getParameter("seq");
		
		int re_index = Integer.parseInt(seq);
		System.out.println("넘어온 리뷰 index: "+re_index);
		singleton s = singleton.getInstance();
		s.orsi.updateReadCount(re_index);
		ModelReviewPurDto dto = s.orsi.getDetailReview(re_index);
		System.out.println("review detail dto : "+dto.toString());
		req.setAttribute("dto", dto);
		ProjectUtil.forward("./client_view/review/reviewdetail.jsp", req, resp);
	}
}
