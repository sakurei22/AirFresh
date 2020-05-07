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

@WebServlet("/reviewList")
public class OrderReviewList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}
	
	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("reviewlist 도착");

		singleton s = singleton.getInstance();
		
		String command = req.getParameter("command");
		
		//페이징
		String snowPage = req.getParameter("nowPage");
		
		int nowPage = 0;
		if(snowPage != null && !snowPage.equals("")){
			nowPage = Integer.parseInt(snowPage);
		}
		
		System.out.println("들어온 nowPage : "+nowPage);
		//총 리뷰게시물 수
		int totalReview = s.orsi.getAllReveiw();
		System.out.println("총 게시물수 : "+totalReview);
		
		//총 페이지수
		int totalPage = totalReview / 10;
		if(totalReview % 10 > 0) {
			totalPage += 1;
		}
		
		
		if(command.equals("user")) {
			List<ModelReviewPurDto> list = s.orsi.pagingAllList(nowPage);
			System.out.println("listsize: "+list.size());
			req.setAttribute("list", list);
			req.setAttribute("totalPage", totalPage);
			req.setAttribute("nowPage", nowPage);
			ProjectUtil.forward("/client_view/review/reviewList.jsp", req, resp);
		} 
		
	}

}
