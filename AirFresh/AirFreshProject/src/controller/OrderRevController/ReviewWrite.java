package controller.OrderRevController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.RentalDetailDto;
import projectutil.ProjectUtil;
import singleton.singleton;


@WebServlet("/reviewWrite")
public class ReviewWrite extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
		System.out.println("reviewWrite 더착");
		req.setCharacterEncoding("utf-8");
		singleton s = singleton.getInstance();
		//작성페이지로 이동 
		String purIndex = req.getParameter("pur")==null?"":req.getParameter("pur");
		System.out.println("purIndex = " + purIndex);
		
		int pur_index = Integer.parseInt(purIndex);
		RentalDetailDto dto = s.ps.getReDetail(pur_index);
		System.out.println("넘어온 dto : "+dto.toString());
		
		req.setAttribute("dto", dto);
		ProjectUtil.forward("/client_view/review/writeOrderReview.jsp", req, resp);
	}
}
