package controller.AsController;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.MemberDto;
import Dto.PurchaseNameDto;
import singleton.singleton;




@WebServlet("/asAppPage")
public class AsAppPage  extends HttpServlet  {
	
	//마이페이지에서 as신청눌렀을때  id, model명 받아오는 곳

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processing(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		processing(req, resp);
	}

	protected void processing(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("as신청 컨트롤러 도착");
		

		//as신청할 주문내역 index,  제품명
		String seq = req.getParameter("seq");
		
		String prd_name =  req.getParameter("prd_name");
		System.out.println("제품명: "+prd_name);
				
		req.getRequestDispatcher("./client_view/as/asapply.jsp?prd="+prd_name+"&seq="+seq).forward(req, resp);
		
	}
	
}
