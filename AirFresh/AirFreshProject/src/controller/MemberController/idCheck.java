package controller.MemberController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import singleton.singleton;

@WebServlet("/idcheck")
public class idCheck extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		this.processFunc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		this.processFunc(req, resp);
	}
			
		public void processFunc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		System.out.println("idCheck 도착");		
		String _id = req.getParameter("_id");
		System.out.println("id:" + _id);
		
		singleton s = singleton.getInstance();
		boolean isS = s.ms.idCheck(_id);
	
		if(isS) {
			//이미 아이디가 존재함
			System.out.println("아이디 사용불가");
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
			
		} else {
			System.out.println("아이디 사용가능");
			//리턴값 타입 json 으로 지정 
			resp.setContentType("application/text");
			resp.setCharacterEncoding("UTF-8");
			
			//list를 json형식의 string으로 변환
			String str = "false";
			String gson = new Gson().toJson(str);
			
			//변환한 json형식을 리턴 
			resp.getWriter().write(gson);
			resp.getWriter().flush();
			resp.getWriter().close();
		}
	
		//resp.sendRedirect(req.getContextPath() + "/client_view/member/idcheck.jsp?isS1=" + isS1);
		//forward("./client_view/member/idcheck.jsp", req, resp);	/WebContent
		//resp.sendRedirect(req.getContextPath() + "/client_view/member/register.jsp");
	}
	

	 
}
