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

@WebServlet("/updateReviewPage")
public class UpdateReviewPage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		System.out.println("updateReview 도착");
		req.setCharacterEncoding("utf-8");
		
		String seq = req.getParameter("seq");
		System.out.println("수정할 index: "+seq);
		
		int re_index = Integer.parseInt(seq);
		singleton s = singleton.getInstance();
		
		ModelReviewPurDto dto = s.orsi.getDetailReview(re_index);
		req.setAttribute("dto", dto);
		ProjectUtil.forward("./client_view/review/updatereview.jsp", req, resp);
	}
}
