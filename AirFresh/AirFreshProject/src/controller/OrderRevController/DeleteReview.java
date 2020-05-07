package controller.OrderRevController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.ModelReviewPurDto;
import projectutil.ProjectUtil;
import singleton.singleton;


@WebServlet("/deleteReview")
public class DeleteReview extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.proc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.proc(req, resp);
	}

	public void proc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		System.out.println("delreview 도착");
		
		String seq = req.getParameter("seq");
		System.out.println("삭제할 index: "+seq);
		int re_index = Integer.parseInt(seq);
		
		singleton s = singleton.getInstance();
		boolean isS = s.orsi.delReivew(re_index);
		
		if(isS) {
			
		// 리뷰 삭제후 finding으로 이동
		resp.sendRedirect(req.getContextPath() + "/client_view/review/finding.jsp?command=del&isS="+isS);
			/*
			 * List<ModelReviewPurDto> list = s.orsi.reviewAllList();
			 * System.out.println("listsize: "+list.size()); req.setAttribute("list", list);
			 * ProjectUtil.forward("/client_view/review/reviewList.jsp", req, resp);
			 */
		}
	}
}
