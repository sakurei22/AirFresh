package controller.PurchaseController;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import Dto.MemberDto;
import Dto.PurchaseDto;
import Dto.PurchaseNameDto;
import singleton.singleton;

@WebServlet("/delPur")
public class delPurchase  extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.process(req, resp);
	}

	public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("delPur 도착");
		
		String seq = req.getParameter("seq");
		int pur_index = Integer.parseInt(seq);
		
		String del = req.getParameter("del");
		System.out.println("넘어온 del : "+del);
		
		HttpSession session = req.getSession();
		MemberDto mem = (MemberDto)session.getAttribute("login");
		String mem_id = mem.getMem_id();
		

		System.out.println("delPur seq: "+seq);
		singleton s = singleton.getInstance();
		
		
		boolean command = s.ps.purchaseDelete(pur_index);
		System.out.println("del pur command: "+command);
		
		if(command) {
			System.out.println("삭제성공");
			
			List<PurchaseNameDto> list = s.ps.memPurchaseList(mem_id);
			req.setAttribute("list", list);
			
			
			if(del.equals("detail")) {
				req.getRequestDispatcher("./client_view/rental/rentallist.jsp").forward(req, resp);
			} else {
			
				//리턴값 타입 json 으로 지정 
				resp.setContentType("application/text");
				resp.setCharacterEncoding("UTF-8");
				
				//list를 json형식의 string으로 변환
				String str = "true";
				String gson = new Gson().toJson(str);
				
				//변환한 json형식을 리턴 
				resp.getWriter().write(gson);
				resp.getWriter().flush();
				resp.getWriter().close();
			}
			
		} else {
			System.out.println("삭제실패");
			
			if(del.equals("detail")) {
				req.getRequestDispatcher("./client_view/rental/rentallist.jsp").forward(req, resp);
			} else {
				
				//리턴값 타입 json 으로 지정 
				resp.setContentType("application/text");
				resp.setCharacterEncoding("UTF-8");
				
				//list를 json형식의 string으로 변환
				//String gson = new Gson().toJson(list);
				String str = "false";
				String gson = new Gson().toJson(str);
				
				//변환한 json형식을 리턴 
				resp.getWriter().write(gson);
				resp.getWriter().flush();
				resp.getWriter().close();
			}
			
		}
		
		//req.getRequestDispatcher("./client_view/rental/rentallist.jsp").forward(req, resp);
		
		//req.getRequestDispatcher("./client_view/rental/delcomplete.jsp?command="+command).forward(req, resp);
	}
}
