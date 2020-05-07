package controller.AsController;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dto.MemberDto;
import Dto.ModelDto;
import Dto.PurchaseDto;
import Dto.PurchaseNameDto;
import singleton.singleton;

/**
 * Servlet implementation class asApply
 */
@WebServlet("/asApply")
public class asApply extends HttpServlet implements Serializable{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proc(request, response);
	}
	
	protected void proc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		singleton s = singleton.getInstance();
		
		if(request.getSession().getAttribute("login") == null) {
			//비로그인 상태   ---> 로그인 페이지로 이동 
			response.sendRedirect(request.getContextPath() + "/client_view/member/login.jsp");
			
		}else {
			//로그인 상태   -----> 제품렌탈(구매) O/X 판단 
			
			MemberDto mdto = (MemberDto)request.getSession().getAttribute("login");
			boolean isS = s.ps.userPurConfirm(mdto.getMem_id());
			
			
			
			if(isS) {
				//구매내역이 있을 때
				//response.sendRedirect(request.getContextPath() + "/client_view/as/asapply.jsp");
				
				
				/* List<PurchaseNameDto> list = s.ps.getModelName(mdto.getMem_id()); */
				List<PurchaseNameDto> list = s.ps.memPurchaseList(mdto.getMem_id());
				
				request.setAttribute("list", list);
				request.getRequestDispatcher("./client_view/rental/rentallist.jsp").forward(request, response);
			}else {
				//구매내역이 없을 때
				//리스트도 같이 보내줘야됨 (제품리스트)
				
				List<ModelDto> list =  s.msi.getModelList();
				
				request.setAttribute("jc", 1);
				request.setAttribute("modelList", list);
				forward("/client_view/model/modellist.jsp", request, response);
				//response.sendRedirect(request.getContextPath() + "/client_view/model/modellist.jsp");
			}
			

		}
	}
	
	protected void forward(String url, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//위에서 로직처리후 url주소와  req(리턴값), resp(리턴)
		//돌아가는 함수
		RequestDispatcher dispatch = req.getRequestDispatcher(url);
		dispatch.forward(req, resp);	
	}
}
