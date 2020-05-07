package controller.OrderRevController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.MemberDto;
import Dto.ModelReviewPurDto;
import projectutil.ProjectUtil;
import singleton.singleton;

@WebServlet("/renReDetail")
public class RentalReviewDetail extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.proc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.proc(req, resp);
	}
	
	public void proc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("RentalReviewDetail 도착");
		
		String pur = req.getParameter("pur");
		System.out.println("들어온 pur_index: "+pur);
		
		HttpSession session = req.getSession();
		MemberDto mem = (MemberDto) session.getAttribute("login");
		String mem_id = mem.getMem_id();
		
		int pur_index = Integer.parseInt(pur);
		singleton s = singleton.getInstance();
		ModelReviewPurDto dto = s.orsi.rentalListReview(mem_id, pur_index);
		
		req.setAttribute("dto", dto);
		ProjectUtil.forward("./client_view/review/reviewdetail.jsp", req, resp);
	}

}
