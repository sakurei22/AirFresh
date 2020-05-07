package controller.PurchaseController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dto.MemberDto;
import Dto.PurchaseDto;
import Dto.PurchaseNameDto;
import singleton.singleton;

@WebServlet("/printPurchase")
public class PrintPurchase extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.setCharacterEncoding("utf-8");
		System.out.println("PrintPurchase 도착");
		
		
		
		if(req.getSession().getAttribute("login") == null) {
			//비로그인 상태   ---> 로그인 페이지로 이동 
			resp.sendRedirect(req.getContextPath() + "/client_view/member/login.jsp");
			
		}else {
		
			HttpSession session = req.getSession();
			MemberDto mem = (MemberDto)session.getAttribute("login");
			String mem_id = mem.getMem_id();
			System.out.println(" PrintPurchase id: "+mem_id);
			//System.out.println("prd_index: "+prd_index);
			
			singleton s = singleton.getInstance();
			List<PurchaseNameDto> list = s.ps.memPurchaseList(mem_id);
			
			//List<PurchaseNameDto> list = s.ps.getModelName(mem_id);
			for (int i = 0; i < list.size(); i++) {
				//System.out.println("렌탈일 : "+list.get(i).getPur_date());
				System.out.println("렌탈INDX: "+list.get(i).getPur_index());
			}
			req.setAttribute("list", list);
			req.getRequestDispatcher("./client_view/rental/rentallist.jsp").forward(req, resp);
		
		}
	}
}
